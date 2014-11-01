package org.bambi.translation_helper.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.bambi.translation_helper.data.WordTranslationDO;


public abstract class ATranslatorDatabase implements ITranslatorDatabase {

  protected static final String PROPERTY_NAME__DB_DRIVER_CLASS = "DB_DRIVER_CLASS";
  protected static final String PROPERTY_NAME__DB_URL = "DB_URL";
  protected static final String PROPERTY_NAME__DB_USERNAME = "DB_USERNAME";
  protected static final String PROPERTY_NAME__DB_PASSWORD = "DB_PASSWORD";

  private Connection dbConnection = null;

  private PreparedStatement findDbTranslationsStatementEquals = null;
//  private PreparedStatement findDbTranslationsStatementLike = null;


  public ATranslatorDatabase() {
    initDbConnection();
    prepareDbStatements();
  }


  private static void closeDbResultSet(ResultSet resultSet) {
    if(resultSet != null) {
      try {
        resultSet.close();
      }
      catch(SQLException exception) {
        throw new RuntimeException("Failed to close ResultSet", exception);
      }
    }
  }


  private void initDbConnection() {
    Properties dbProperties = getDbProperties();

    try {
      Class.forName(dbProperties.getProperty(PROPERTY_NAME__DB_DRIVER_CLASS));

      dbConnection = DriverManager.getConnection(dbProperties.getProperty(PROPERTY_NAME__DB_URL),
          dbProperties.getProperty(PROPERTY_NAME__DB_USERNAME), dbProperties.getProperty(PROPERTY_NAME__DB_PASSWORD));
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to init DbConnection", exception);
    }
  }

  
  private void prepareDbStatements() {
    try {
      findDbTranslationsStatementEquals = dbConnection.prepareStatement(
          "select word.WORD, word.WORD_FLAT, translation.TRANSLATION, word_translation.CATEGORY, word_translation.PRIORITY " + 
          "from word, word_translation, translation " + 
          "where word_translation.WORD_ID = word.WORD_ID " + 
            "and word_translation.TRANSLATION_ID = translation.TRANSLATION_ID " + 
            "and word.WORD_FLAT = ? " +
          "order by word.WORD_FLAT, word_translation.CATEGORY, word_translation.PRIORITY");
      
//      findDbTranslationsStatementLike = dbConnection.prepareStatement("select * from DICTIONARY where WORD like ?");
    }
    catch(Exception exception) {
      throw new RuntimeException("Failed to prepare Db statements", exception);
    }
  }
  

  protected abstract Properties getDbProperties();

  
  public List<WordTranslationDO> findTranslationsByWordFlat(String wordFlat) {
    List<WordTranslationDO> translationList = new ArrayList<WordTranslationDO>();
    ResultSet resultSet = null;

    try {
      findDbTranslationsStatementEquals.clearParameters();
      findDbTranslationsStatementEquals.setString(1, wordFlat);

      resultSet = findDbTranslationsStatementEquals.executeQuery();
      
      while(resultSet.next()) {
        WordTranslationDO wordTranslationDO = new WordTranslationDO(
            resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5));

        translationList.add(wordTranslationDO);
      }
    }
    catch(SQLException exception) {
      throw new RuntimeException("Failed to select translation", exception);
    }
    finally {
      closeDbResultSet(resultSet);
    }

    return translationList;
  }

}
