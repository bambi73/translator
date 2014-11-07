package org.bambi.translator.translator.helper;

import java.util.HashMap;
import java.util.Map;

import net.sf.junidecode.Junidecode;


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

  
  public static String getDictionaryTranslation(String word) {
    return hangul2Romanization.get(word);
  }

  
  public static String getRomanizedTranslation(String word) {
    return Junidecode.unidecode(word);
  }
  
}
