package org.bambi.translator.data_bak;

public class WordTranslationDO {

  private String word = null;
  private String wordFlat = null;
  private String translation = null;

  private int category;
  private int priority;


  public WordTranslationDO(String word, String wordFlat) {
    this.word = word;
    this.wordFlat = wordFlat;
  }


  public WordTranslationDO(String word, String wordFlat, String translation, int category, int priority) {
    this(word, wordFlat);

    this.translation = translation;
    this.category = category;
    this.priority = priority;
  }


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


  public int getCategory() {
    return category;
  }


  public void setCategory(int category) {
    this.category = category;
  }


  public int getPriority() {
    return priority;
  }


  public void setPriority(int priority) {
    this.priority = priority;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("DbWordTranslationDO [word=").append(word).append(", ");
    builder.append("wordFlat=").append(wordFlat).append(", ");
    builder.append("translation=").append(translation).append(", ");
    builder.append("category=").append(category).append(", ");
    builder.append("priority=").append(priority);
    builder.append("]");

    return builder.toString();
  }

}
