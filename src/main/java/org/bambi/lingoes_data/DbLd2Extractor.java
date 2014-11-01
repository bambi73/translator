package org.bambi.lingoes_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public abstract class DbLd2Extractor extends FileLd2Extractor {

  private static final String DB_URL_PREFIX = "jdbc:mysql://localhost/";
  private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_USERNAME = "th";
  private static final String DB_PASSWORD = "th";

  private Connection connection = null;

  private PreparedStatement wordInsertPS = null;
  private PreparedStatement wordTranslationInsertPS = null;
  private PreparedStatement translationInsertPS = null;
  private PreparedStatement translationContextInsertPS = null;

  private PreparedStatement wordSelectPS = null;
  private PreparedStatement wordTranslationSelectPS = null;

  private long lastTranslationID = 0;
  private long lastWordID = 0;


  protected abstract String getDbName();


  private void initDbConnection() {
    try {
      Class.forName(DB_DRIVER);
      connection = DriverManager.getConnection(DB_URL_PREFIX + getDbName(), DB_USERNAME, DB_PASSWORD);
      connection.setAutoCommit(true);
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to init DbConnection", exception);
    }
  }


  private void initDb() {
    try {
      System.out.println("Cleaning up DB before import");

      connection.prepareStatement("delete from TRANSLATION_CONTEXT").executeUpdate();
      connection.prepareStatement("delete from WORD_TRANSLATION").executeUpdate();
      connection.prepareStatement("delete from TRANSLATION").executeUpdate();
      connection.prepareStatement("delete from WORD").executeUpdate();

      lastTranslationID = 0;
      lastWordID = 0;

      System.out.println("Cleaning up DB before import ... done");
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to init Db", exception);
    }
  }


  private void prepareDbStatements() {
    try {
      wordInsertPS = connection.prepareStatement("insert into WORD(WORD_ID, WORD_FLAT, WORD) values (?,?,?)");
      wordTranslationInsertPS = connection.prepareStatement("insert into WORD_TRANSLATION(WORD_ID, TRANSLATION_ID, CATEGORY, PRIORITY) values (?,?,?,?)");
      translationInsertPS = connection.prepareStatement("insert into TRANSLATION(TRANSLATION_ID, TRANSLATION) values (?,?)");
      translationContextInsertPS = connection.prepareStatement("insert into TRANSLATION_CONTEXT(TRANSLATION_ID, WORD_ID) values (?,?)");

      wordSelectPS = connection.prepareStatement("select WORD_ID from WORD where WORD_FLAT = ? and WORD = ?");
      wordTranslationSelectPS = connection.prepareStatement("select max(PRIORITY) from WORD_TRANSLATION where WORD_ID = ? and CATEGORY = ?");
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to prepare Db statements", exception);
    }
  }


  protected long saveWord(String word) {
    try {
      word = word.trim();

      if(word.length() > 0) {
        String wordFlat = word.replaceAll("\\s+", "");

        wordSelectPS.setString(1, wordFlat);
        wordSelectPS.setString(2, word);
        ResultSet rs = wordSelectPS.executeQuery();

        if(rs.next()) {
          return rs.getLong(1);
        }

        wordInsertPS.setLong(1, ++lastWordID);
        wordInsertPS.setString(2, wordFlat);
        wordInsertPS.setString(3, word);
        wordInsertPS.executeUpdate();

        return lastWordID;
      }
      else {
        return -1L;
      }
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to save word '" + word + "' into DB", exception);
    }
  }


  protected long saveTranslation(String translation) {
    try {
      translation = translation.trim();

      if(translation.length() > 0) {
        translationInsertPS.setLong(1, ++lastTranslationID);
        translationInsertPS.setString(2, translation);
        translationInsertPS.executeUpdate();

        return lastTranslationID;
      }
      else {
        return -1L;
      }
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to save translation '" + translation + "' into DB", exception);
    }
  }


  protected void saveWordTranslation(long wordID, long translationID, int category) {
    try {
      wordTranslationSelectPS.setLong(1, wordID);
      wordTranslationSelectPS.setInt(2, category);
      ResultSet rs = wordTranslationSelectPS.executeQuery();
      int priority = 0;

      if(rs.next()) {
        priority = rs.getInt(1);
      }

      wordTranslationInsertPS.setLong(1, wordID);
      wordTranslationInsertPS.setLong(2, translationID);
      wordTranslationInsertPS.setInt(3, category);
      wordTranslationInsertPS.setInt(4, priority + 1);
      wordTranslationInsertPS.executeUpdate();
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to save word translation into DB", exception);
    }
  }


  protected void saveTranslationContext(long translationID, long wordID) {
    try {
      translationContextInsertPS.setLong(1, translationID);
      translationContextInsertPS.setLong(2, wordID);
      translationContextInsertPS.executeUpdate();
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to save translation context into DB", exception);
    }
  }
  
  
  @Override
  protected void beforeTranslation() {
    super.beforeTranslation();

    initDbConnection();
    initDb();
    prepareDbStatements();
  }


  @Override
  protected void afterTranslation() {
    try {
      if(connection != null) {
        connection.close();
      }
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to close DbConnection", exception);
    }
    finally {
      connection = null;
      super.afterTranslation();
    }
  }

}
