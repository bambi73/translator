package org.bambi.translator.data;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import org.bambi.translator.data.type.ETranslationCategory;
import org.bambi.translator.data.type.ETranslationOrigin;
import org.bambi.translator.data.type.ETranslationProvider;
import org.bambi.translator.data.type.ETranslationType;


public class TranslationDataDO {

  private String word = null;
  private String wordFlat = null;
  private String translation = null;

  private ETranslationProvider provider = null;
  private ETranslationType type = null;
  private ETranslationOrigin origin = null;
  private ETranslationCategory category = null;

  private int order;

  private List<AGrammarContextDO> grammarContextList = null;


  public String getWord() {
    return word;
  }


  public void setWord(String word) {
    this.word = word;
  }


  public String getWordFlat() {
    return wordFlat;
  }


  public void setWordFlat(String wordFlat) {
    this.wordFlat = wordFlat;
  }


  public String getTranslation() {
    return translation;
  }


  public void setTranslation(String translation) {
    this.translation = translation;
  }


  public ETranslationProvider getProvider() {
    return provider;
  }


  public void setProvider(ETranslationProvider provider) {
    this.provider = provider;
  }


  public ETranslationType getType() {
    return type;
  }


  public void setType(ETranslationType type) {
    this.type = type;
  }


  public ETranslationOrigin getOrigin() {
    return origin;
  }


  public void setOrigin(ETranslationOrigin origin) {
    this.origin = origin;
  }


  public ETranslationCategory getCategory() {
    return category;
  }


  public void setCategory(ETranslationCategory category) {
    this.category = category;
  }


  public int getOrder() {
    return order;
  }


  public void setOrder(int order) {
    this.order = order;
  }


  public List<AGrammarContextDO> getGrammarContextList() {
    return grammarContextList;
  }


  public void setGrammarContextList(List<AGrammarContextDO> grammarContextList) {
    this.grammarContextList = grammarContextList;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("TranslationDataDO [");
    builder.append("translation=\"").append(translation).append("\", ");
    builder.append("word=\"").append(word).append("\", ");
    builder.append("wordFlat=\"").append(wordFlat).append("\", ");

    builder.append("provider=").append(provider).append(", ");
    builder.append("type=").append(type).append(", ");
    builder.append("origin=").append(origin).append(", ");
    builder.append("category=").append(category).append(", ");
    builder.append("order=").append(order);

    if(CollectionUtils.isNotEmpty(grammarContextList)) {
      builder.append(", grammarContextList={\n");

      for(int i = 0; i < grammarContextList.size(); i++) {
        if(i > 0) {
          builder.append(",\n");
        }

        builder.append("      ").append(grammarContextList.get(i));
      }

      builder.append("\n   }]");
    }
    else {
      builder.append("]");
    }

    return builder.toString();
  }

}
