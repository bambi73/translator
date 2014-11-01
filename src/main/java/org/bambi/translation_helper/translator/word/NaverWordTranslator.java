package org.bambi.translation_helper.translator.word;

import org.bambi.translation_helper.database.NaverTranslatorDatabase;

public class NaverWordTranslator extends WordTranslator {

  public NaverWordTranslator() {
    super(new NaverTranslatorDatabase());
  }

}
