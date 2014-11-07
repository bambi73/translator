package org.bambi.translator.translator.word;

import org.bambi.translator.database.NaverTranslatorDatabase;

public class NaverWordTranslator extends DatabaseWordTranslator {

  public NaverWordTranslator() {
    super(new NaverTranslatorDatabase());
  }

}
