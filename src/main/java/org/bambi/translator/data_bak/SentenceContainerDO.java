package org.bambi.translator.data_bak;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class SentenceContainerDO {

  private String sentence = null;
  private List<WordDataDO> wordDataList = null;


  private static List<WordDataDO> prepareWordDataList(String sentence) {
    StringTokenizer tokenizer = new StringTokenizer(sentence, " .,;\"\t\n\r\f");
    List<WordDataDO> wordDataList = new ArrayList<WordDataDO>();

    while(tokenizer.hasMoreTokens()) {
      wordDataList.add(new WordDataDO(tokenizer.nextToken()));
    }

    return wordDataList;
  }


  public SentenceContainerDO(String sentence) {
    this.sentence = sentence;
    this.wordDataList = prepareWordDataList(sentence);
  }


  public String getSentence() {
    return sentence;
  }


  public List<WordDataDO> getWordDataList() {
    return wordDataList;
  }


  public int getSize() {
    return wordDataList.size();
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    
    builder.append("SentenceContainer [");
    builder.append("\n  sentence = ").append(sentence);
    builder.append("\n  wordDataList = {");

    for(WordDataDO wordData : wordDataList) {
      builder.append("\n    ");
      builder.append(wordData.toString());
    }

    builder.append("\n  }");

    return builder.toString();
  }

}
