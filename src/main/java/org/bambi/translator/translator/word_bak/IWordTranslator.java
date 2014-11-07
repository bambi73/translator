package org.bambi.translator.translator.word_bak;

import org.bambi.translator.data_bak.WordDataDO;
import org.bambi.translator.data_bak.type.ETranslationType;

public interface IWordTranslator {

  public boolean translate(ETranslationType translationType, WordDataDO wordData);
  
}
