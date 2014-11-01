package org.bambi.translation_helper.translator.helper;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.junidecode.Junidecode;

import org.bambi.translation_helper.data.WordTranslationDO;


public class KoreanRomanizationHelper {

  private static Map<String, String> hangul2Romanization = new HashMap<String, String>();

  static {
    hangul2Romanization.put("위드", "Weed");
    hangul2Romanization.put("이현", "Lee Hyun");
    hangul2Romanization.put("혜연", "Hye Yeon");
    hangul2Romanization.put("서윤", "Seoyoon");
    hangul2Romanization.put("로뮤", "Romuna");
    hangul2Romanization.put("페일", "Paul");
    hangul2Romanization.put("이리엔", "Irene");
    hangul2Romanization.put("수르카", "Surka");
  }


  public static WordTranslationDO getRomanizedWordTranslation(String word) {
    WordTranslationDO wordTranslation = new WordTranslationDO(word, word);
    String romanization = hangul2Romanization.get(word);
    
    if(romanization != null) {
      wordTranslation.setTranslation(romanization);
      wordTranslation.setCategory(0);
      wordTranslation.setPriority(0);
    }
    else {
      wordTranslation.setTranslation(Junidecode.unidecode(word));
      wordTranslation.setCategory(10);
      wordTranslation.setPriority(0);
    }
    
    return wordTranslation;
  }

  
  public static List<WordTranslationDO> getRomanizedWordTranslationList(String word) {
    return Collections.singletonList(getRomanizedWordTranslation(word));
  }
  
}
