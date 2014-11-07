package org.bambi.translator.translator.sentence;

import org.bambi.translator.translator.word.IWordTranslator;
import org.bambi.translator.translator.word.NaverWordTranslator;



public class NaverWordByWordSentenceTranslator extends AWordByWordSentenceTranslator {

  private IWordTranslator wordTranslator = null;


  @Override
  public IWordTranslator getWordTranslator() {
    return (wordTranslator != null ? wordTranslator : (wordTranslator = new NaverWordTranslator()));
  }

}
