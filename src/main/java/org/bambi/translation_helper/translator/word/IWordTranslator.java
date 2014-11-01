package org.bambi.translation_helper.translator.word;

import org.bambi.translation_helper.data.WordDataDO;
import org.bambi.translation_helper.data.type.ETranslationType;

public interface IWordTranslator {

  public boolean translate(ETranslationType translationType, WordDataDO wordData);
  
}
