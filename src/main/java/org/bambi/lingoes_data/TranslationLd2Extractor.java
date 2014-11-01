package org.bambi.lingoes_data;

import java.util.ArrayList;
import java.util.List;


public abstract class TranslationLd2Extractor extends DbLd2Extractor {

  private static String START_STRING = "<![CDATA[";
  private static String END_STRING = "]]>";


  protected List<String> getTranslationSubList(String translation) {
    List<String> translationSubList = new ArrayList<String>();
    int position = 0;

    while(true) {
      int startIndex = translation.indexOf(START_STRING, position);

      if(startIndex >= 0) {
        int endIndex = translation.indexOf(END_STRING, startIndex + START_STRING.length());

        if(endIndex >= 0) {
          String subTranslation = translation
              .substring(startIndex + START_STRING.length(), endIndex)
              .replace('\t', ' ')
              .replace(Helper.SEP_NEWLINE_CHAR, ' ')
              .replace('\u001e', ' ')
              .replace('\u001f', ' ')
              .trim();
          
          if(subTranslation.length() > 0) {
            translationSubList.add(subTranslation);
          }

          position = endIndex + END_STRING.length();
        }
        else {
          System.err.println("Failed to find " + END_STRING + " for\n" + translation.substring(startIndex) + "\nin\n" + translation);
          break;
        }
      }
      else {
        break;
      }
    }

    return translationSubList;
  }

}
