package org.bambi.translator.data.type;

public enum ETranslationCategory {

  WORD(0), 
  MEANING(10);

  private int dbValue;

  ETranslationCategory(int dbValue) {
    this.dbValue = dbValue;
  }

  public int getDbValue() {
    return dbValue;
  }

  public static ETranslationCategory fromDbValue(int dbValue) {
    for(ETranslationCategory translationCategory : values()) {
      if(translationCategory.dbValue == dbValue) {
        return translationCategory;
      }
    }

    throw new IllegalArgumentException(String.format("Invalid dbValue '%d' for ETranslationCategory", dbValue));
  }

}
