package org.bambi.translation_helper.database;

import java.util.List;

import org.bambi.translation_helper.data.WordTranslationDO;
import org.bambi.translation_helper.data.type.ETranslatorProvider;

public interface ITranslatorDatabase {

  public ETranslatorProvider getTranslatorProvider();
  
  public List<WordTranslationDO> findTranslationsByWordFlat(String wordFlat);

}
