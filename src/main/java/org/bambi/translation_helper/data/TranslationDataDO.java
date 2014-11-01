package org.bambi.translation_helper.data;

public class TranslationDataDO {

  private WordTranslationDO wordTranslation = null;
  private GrammarContextContainerDO grammarContextContainer = null;


  public TranslationDataDO(WordTranslationDO wordTranslation) {
    this.wordTranslation = wordTranslation;
  }


  public String getTranslation() {
    return wordTranslation.getTranslation();
  }


  public GrammarContextContainerDO getGrammarContextContainer() {
    return grammarContextContainer;
  }


  public void setGrammarContextContainer(GrammarContextContainerDO grammarContextContainer) {
    this.grammarContextContainer = grammarContextContainer;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("TranslationDataDO [");
    builder.append("translation=\"").append(wordTranslation.getTranslation()).append("\", ");
    builder.append("word=\"").append(wordTranslation.getWord()).append("\", ");
    builder.append("wordFlat=\"").append(wordTranslation.getWordFlat()).append("\", ");
    builder.append("category=").append(wordTranslation.getCategory()).append(", ");
    builder.append("priority=").append(wordTranslation.getPriority());
    
    if(grammarContextContainer != null) {
      builder.append("\n").append(grammarContextContainer).append("\n      ]");
    }
    else {
      builder.append("]");
    }
    
    return builder.toString();
  }

}
