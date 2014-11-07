package org.bambi.translator.database;

import java.util.Properties;

import org.bambi.translator.data.type.ETranslationProvider;


public class NaverTranslatorDatabase extends ATranslatorDatabase {

  @Override
  protected Properties getDbProperties() {
    Properties dbProperties = new Properties();

    dbProperties.setProperty(PROPERTY_NAME__DB_DRIVER_CLASS, "com.mysql.jdbc.Driver");
    dbProperties.setProperty(PROPERTY_NAME__DB_URL, "jdbc:mysql://localhost/th_naver");
    dbProperties.setProperty(PROPERTY_NAME__DB_USERNAME, "th");
    dbProperties.setProperty(PROPERTY_NAME__DB_PASSWORD, "th");

    return dbProperties;
  }


  public ETranslationProvider getTranslationProvider() {
    return ETranslationProvider.NAVER;
  }

}
