package org.bambi.translator.data_bak;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bambi.translator.data_bak.type.ETranslationType;


public class WordDataDO {

  private Map<ETranslationType, TranslationContainerDO> type2translationContainer = new HashMap<ETranslationType, TranslationContainerDO>();
  private String word = null;


  public WordDataDO(String word) {
    this.word = word;
  }


  public TranslationContainerDO getTranslationContainerDO(ETranslationType translationType) {
    TranslationContainerDO translationContainer = type2translationContainer.get(translationType);

    if(translationContainer == null) {
      type2translationContainer.put(translationType, translationContainer = new TranslationContainerDO(translationType));
    }

    return translationContainer;
  }


  public String getWord() {
    return word;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    
    builder.append("WordDataDO [word=").append(word).append(", ");
    builder.append("type2translationContainer={");
    
    for(Entry<ETranslationType, TranslationContainerDO> entry : type2translationContainer.entrySet()) {
      builder.append("\n  ");
      builder.append(entry);
    }
    builder.append((type2translationContainer.isEmpty() ? "" : "\n") + "}]");
    
    return builder.toString();
  }

}
