package org.bambi.translation_helper.translator.sentence;

import org.bambi.translation_helper.translator.word.IWordTranslator;
import org.bambi.translation_helper.translator.word.NaverWordTranslator;


public class NaverWordByWordSentenceTranslator extends AWordByWordSentenceTranslator {

  private IWordTranslator wordTranslator = null;


  @Override
  public IWordTranslator getWordTranslator() {
    return (wordTranslator != null ? wordTranslator : (wordTranslator = new NaverWordTranslator()));
  }

}
