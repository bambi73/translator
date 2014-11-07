package org.bambi.translator.translator.word_bak;

import org.bambi.translator.database.NaverTranslatorDatabase;

public class NaverWordTranslator extends WordTranslator {

  public NaverWordTranslator() {
    super(new NaverTranslatorDatabase());
  }

}
