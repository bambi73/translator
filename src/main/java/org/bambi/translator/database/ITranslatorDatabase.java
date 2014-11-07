package org.bambi.translator.database;

import java.util.List;

import org.bambi.translator.data.WordTranslationDO;
import org.bambi.translator.data.type.ETranslationProvider;

public interface ITranslatorDatabase {

  public ETranslationProvider getTranslationProvider();
  
  public List<WordTranslationDO> findTranslationsByWordFlat(String wordFlat);

}
