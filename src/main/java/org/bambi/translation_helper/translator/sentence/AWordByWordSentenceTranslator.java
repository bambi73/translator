package org.bambi.translation_helper.translator.sentence;

import java.util.List;

import org.bambi.translation_helper.data.SentenceContainerDO;
import org.bambi.translation_helper.data.WordDataDO;
import org.bambi.translation_helper.data.type.ETranslationType;
import org.bambi.translation_helper.translator.word.IWordTranslator;


public abstract class AWordByWordSentenceTranslator extends ASentenceTranslator {

  public abstract IWordTranslator getWordTranslator();


  public void translate(SentenceContainerDO sentenceContainer) {
    if(sentenceContainer.getSize() > 0) {
      List<WordDataDO> wordDataList = sentenceContainer.getWordDataList();

      for(WordDataDO wordData : wordDataList) {
        getWordTranslator().translate(ETranslationType.DIRECT, wordData);
        getWordTranslator().translate(ETranslationType.RECURSIVE, wordData);
        getWordTranslator().translate(ETranslationType.PARTICLE, wordData);
        getWordTranslator().translate(ETranslationType.ROMANIZATION, wordData);
        
        System.err.println(wordData);
        System.err.println();
        System.err.println();
      }
    }
  }

}
