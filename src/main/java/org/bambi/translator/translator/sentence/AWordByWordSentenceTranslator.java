package org.bambi.translator.translator.sentence;

import java.util.List;

import org.bambi.translator.data.SentenceContainerDO;
import org.bambi.translator.data.WordDataDO;
import org.bambi.translator.translator.word.IWordTranslator;


public abstract class AWordByWordSentenceTranslator extends ASentenceTranslator {

  public abstract IWordTranslator getWordTranslator();


  public void translate(SentenceContainerDO sentenceContainer) {
    if(sentenceContainer.getSize() > 0) {
      List<WordDataDO> wordDataList = sentenceContainer.getWordDataList();

      for(WordDataDO wordData : wordDataList) {
        getWordTranslator().translate(wordData);
        
        System.err.println(wordData);
        System.err.println();
        System.err.println();
      }
    }
  }

}
