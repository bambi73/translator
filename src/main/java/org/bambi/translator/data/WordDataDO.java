package org.bambi.translator.data;

import java.util.ArrayList;
import java.util.List;


public class WordDataDO {

  private List<TranslationDataDO> translationDataList = new ArrayList<TranslationDataDO>();
  private String word = null;


  public WordDataDO(String word) {
    this.word = word;
  }


  public String getWord() {
    return word;
  }


  public List<TranslationDataDO> getTranslationDataList() {
    return translationDataList;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("WordDataDO [word=").append(word).append(", ");
    builder.append("translationList={");

    for(TranslationDataDO translationData : translationDataList) {
      builder.append("\n   ").append(translationData);
    }

    builder.append((translationDataList.isEmpty() ? "" : "\n") + "}]");

    return builder.toString();
  }

}
