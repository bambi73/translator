package org.bambi.translation_helper.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bambi.translation_helper.data.type.ETranslationType;
import org.bambi.translation_helper.data.type.ETranslatorProvider;
import org.bambi.translation_helper.utils.Utils;


public class TranslationContainerDO {

  private Map<ETranslatorProvider, List<TranslationDataDO>> provider2TranslationDataList = 
      new HashMap<ETranslatorProvider, List<TranslationDataDO>>();
  private ETranslationType translationType = null;


  public TranslationContainerDO(ETranslationType translationType) {
    this.translationType = translationType;
  }


  public ETranslationType getTranslationType() {
    return translationType;
  }

  
  public List<TranslationDataDO> getTranslationDataList(ETranslatorProvider translatorProvider) {
    return Utils.getListInMap(provider2TranslationDataList, translatorProvider);
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    
    builder.append("TranslationContainerDO [translationType=").append(translationType).append(", ");
    builder.append("provider2TranslationDataList={");
    
    for(Entry<ETranslatorProvider, List<TranslationDataDO>> entry : provider2TranslationDataList.entrySet()) {
      builder.append("\n    ").append(entry.getKey()).append("=[");

      for(TranslationDataDO translationData : entry.getValue()) {
        builder.append("\n      ").append(translationData).append(",");
      }

      builder.append((entry.getValue().isEmpty() ? "" : "\n    ") + "]");
    }
    
    builder.append((provider2TranslationDataList.isEmpty() ? "" : "\n  ") + "}]");
    
    return builder.toString();
  }


}
