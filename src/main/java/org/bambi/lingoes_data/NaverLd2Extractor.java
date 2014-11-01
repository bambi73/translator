package org.bambi.lingoes_data;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NaverLd2Extractor extends TranslationLd2Extractor {

  private static final String FILE_INPUT = "target/classes/dictionaries/Naver Korean-English Dictionary.ld2";
  private static final String FILE_OUTPUT = "target/classes/dictionaries/Naver-Plain.txt";

  private static final String DB_NAME = "th_naver";

  private static final String SPLIT_REGEXP__END_OF_LINE = "\\s*<br />\\s*";
  private static final String SPLIT_REGEXP__WORD_ELEMENT = "(?=<B>)";

  private static final String MATCH_REGEXP__WORD_ELEMENT = "<B>([^<]*)</B>(.*)";
  private static final String MATCH_REGEXP__WORD_ELEMENT_REMAINDER = "\\s*(?:【([^】]*)】)?([^【]*)";
  private static final String MATCH_REGEXP__MEANING_ELEMENT = "▶\\s*([^\u0041-\u005A\u0061-\u007A]*)\\s*(.*)";
  private static final String MATCH_REGEXP__ANY_HANGUL = ".*[\u1000-\uFFFF].*";

  private static final String CLEANUP_XML_REGEXP__KANJI = "</B>\\([^)]*\\)";
  private static final String CLEANUP_XML_REGEXP__BOLD = "<b>";
  private static final String CLEANUP_XML_REGEXP__SUP = "<SUP[^>]*>[^<]*</SUP>";
  private static final String CLEANUP_XML_REGEXP__BRACES_1 = "</B>\\s*\\[([^]]*)\\]";
  private static final String CLEANUP_XML_REGEXP__BRACES_2 = "『[^』]*』";
  private static final String CLEANUP_XML_REGEXP__BRACES_3 = "([^\\s])《([^》]*)》";
  private static final String CLEANUP_XML_REGEXP__BRACES_4 = "\\s《([^》]*)》";
  private static final String CLEANUP_XML_REGEXP__BRACES_5 = "<B>】</B>";
  private static final String CLEANUP_XML_REGEXP__BRACES_6 = "<B>【</B>";
  private static final String CLEANUP_XML_REGEXP__BRACES_7 = "<B>\\(</B>";

  private static final String CLEANUP_TRANSLATION_REGEXP__HANGUL_1 = "\\s*\\((?=[^)]*[\u1000-\uFFFF]+[^)]*)[^)]*\\)";
  private static final String CLEANUP_TRANSLATION_REGEXP__HANGUL_2 = "\\s*\\{(?=[^}]*[\u1000-\uFFFF]+[^}]*)[^}]*\\}";
  private static final String CLEANUP_TRANSLATION_REGEXP__HANGUL_3 = "\\s*⇒(?=.*[\u1000-\uFFFF]+.*).*";
  private static final String CLEANUP_TRANSLATION_REGEXP__HANGUL_4 = "\\s*▶(?=.*[\u1000-\uFFFF]+.*).*";
  private static final String CLEANUP_TRANSLATION_REGEXP__SEMI_COLON = "\\s*;\\s*;\\s*";
  private static final String CLEANUP_TRANSLATION_REGEXP__SPACE = "\\s{2,}";

  private static final String CLEANUP_WORD_REGEXP__BRACES_1 = "\\(-([^)]*)\\)";
  private static final String CLEANUP_WORD_REGEXP__BRACES_2 = "\\(([^)]*)\\)";
  private static final String CLEANUP_WORD_REGEXP__BRACES_3 = "\\[-([^)]*)\\]";
  private static final String CLEANUP_WORD_REGEXP__BRACES_4 = "\\[([^)]*)\\]";
  private static final String CLEANUP_WORD_REGEXP__BRACES_5 = "\\([^)]*\\)";
  private static final String CLEANUP_WORD_REGEXP__BRACES_6 = "\\[[^)]*\\]";

  private static final String CLEANUP_CONTEXT_WORD_REGEXP__BRACES_1 = "\\([^)]*\\)";

  private static final String CLEANUP_MEANING_TRANSLATION_REGEXP__HANGUL_1 = "\\s*\\((?=[^)]*[\u1000-\uFFFF]+[^)]*)[^)]*\\)";
  private static final String CLEANUP_MEANING_TRANSLATION_REGEXP__HANGUL_2 = "\\s*\\{(?=[^}]*[\u1000-\uFFFF]+[^}]*)[^}]*\\}";
  private static final String CLEANUP_MEANING_TRANSLATION_REGEXP__CONTEXT = "【[^】]*】";
  private static final String CLEANUP_MEANING_TRANSLATION_REGEXP__SPECIAL = "[─―“”‘´°′’℃…]+";

  private Map<String, Integer> keyWord2Count = new HashMap<String, Integer>();
  private int count = 0;

  private class ContextTranslationTuple {
    String contextWord = null;
    String translation = null;


    public ContextTranslationTuple(String contextWord, String translation) {
      this.contextWord = contextWord;
      this.translation = translation;
    }
  }


  private static String stringJoin(List<String> stringList, String prefix, String postfix, String delimiter) {
    StringBuilder builder = new StringBuilder();

    if(stringList != null) {
      for(String string : stringList) {
        if(builder.length() > 0) {
          builder.append(delimiter);
        }

        builder.append(string);
      }
    }

    return (builder.length() > 0 ? prefix + builder.toString() + postfix : "null");
  }


  private String[] cleanupEmptyLines(String[] stringLineArray) {
    List<String> translationLineList = new ArrayList<String>();

    for(String translationLine : stringLineArray) {
      if(!translationLine.trim().isEmpty()) {
        translationLineList.add(translationLine.trim());
      }
    }

    return translationLineList.toArray(new String[translationLineList.size()]);
  }


  private String[] cleanupTranslationLineArray(String[] translationLineArray) {
    for(int i = 0; i < translationLineArray.length; i++) {
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__KANJI, "</B>");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__BOLD, "");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__SUP, "");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__BRACES_1, "</B>【$1】");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__BRACES_2, "");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__BRACES_3, "$1 {$2}");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__BRACES_4, " {$1}");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__BRACES_5, "】");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__BRACES_6, "【");
      translationLineArray[i] = translationLineArray[i].replaceAll(CLEANUP_XML_REGEXP__BRACES_7, "(");
      translationLineArray[i] = translationLineArray[i].trim();
    }

    String previousBLine = null;

    for(int i = 0; i < translationLineArray.length; i++) {
      if(!translationLineArray[i].isEmpty()) {
        if(translationLineArray[i].startsWith("<B>")) {
          previousBLine = translationLineArray[i];
        }
        else if(translationLineArray[i].startsWith("<font color=\"#FF0000\">")) {
          translationLineArray[i] = translationLineArray[i].replaceFirst("<font color=\"#FF0000\">\\d+</font>\\s*</b>", previousBLine);
        }
      }
    }

    return cleanupEmptyLines(translationLineArray);
  }


  private String cleanupTranslation(String translation) {
    translation = translation.replaceAll(CLEANUP_TRANSLATION_REGEXP__HANGUL_1, "");
    translation = translation.replaceAll(CLEANUP_TRANSLATION_REGEXP__HANGUL_2, "");
    translation = translation.replaceAll(CLEANUP_TRANSLATION_REGEXP__HANGUL_3, "");
    translation = translation.replaceAll(CLEANUP_TRANSLATION_REGEXP__HANGUL_4, "");
    translation = translation.replaceAll(CLEANUP_TRANSLATION_REGEXP__SEMI_COLON, "; ");
    translation = translation.replaceAll(CLEANUP_TRANSLATION_REGEXP__SPACE, " ");
    translation = translation.trim();

    return translation;
  }


  private List<String> cleanupWord(String word) {
    String word1 = null;
    String word2 = null;

    word1 = word.replaceAll(CLEANUP_WORD_REGEXP__BRACES_1, "$1");
    word1 = word1.replaceAll(CLEANUP_WORD_REGEXP__BRACES_2, "$1");
    word1 = word1.replaceAll(CLEANUP_WORD_REGEXP__BRACES_3, "$1");
    word1 = word1.replaceAll(CLEANUP_WORD_REGEXP__BRACES_4, "$1");

    word2 = word.replaceAll(CLEANUP_WORD_REGEXP__BRACES_5, "");
    word2 = word2.replaceAll(CLEANUP_WORD_REGEXP__BRACES_6, "");

    if(!word.equals(word1)) {
      return Arrays.asList(new String[] { word1, word2 });
    }
    else {
      return Arrays.asList(new String[] { word });
    }
  }


  private String cleanupContextWord(String contextWord) {
    contextWord = contextWord.replaceAll(CLEANUP_CONTEXT_WORD_REGEXP__BRACES_1, "");
    contextWord = contextWord.trim();

    return contextWord;
  }


  private String cleanupMeaningTranslation(String meaningTranslation) {
    meaningTranslation = meaningTranslation.replaceAll(CLEANUP_MEANING_TRANSLATION_REGEXP__HANGUL_1, "");
    meaningTranslation = meaningTranslation.replaceAll(CLEANUP_MEANING_TRANSLATION_REGEXP__HANGUL_2, "");
    meaningTranslation = meaningTranslation.trim();

    return meaningTranslation;
  }


  private String cleanupMeaningContext(String meaningContext) {
    meaningContext = meaningContext.replaceAll(CLEANUP_MEANING_TRANSLATION_REGEXP__CONTEXT, "");
    meaningContext = meaningContext.replaceAll(CLEANUP_MEANING_TRANSLATION_REGEXP__SPECIAL, "");
    meaningContext = meaningContext.trim();

    return meaningContext;
  }


  private void processTranslation(List<String> wordList, String translationRemainder, int category) {
    Matcher remainderMatcher = Pattern.compile(MATCH_REGEXP__WORD_ELEMENT_REMAINDER).matcher(translationRemainder);
    List<ContextTranslationTuple> contextTranslationTupleList = new ArrayList<ContextTranslationTuple>();

    while(remainderMatcher.find()) {
      String contextWord = remainderMatcher.group(1);
      String translation = remainderMatcher.group(2).trim();

      if(!translation.endsWith("】")) {
        ContextTranslationTuple contextTranslationTuple = new ContextTranslationTuple(
            (contextWord != null && contextWord.trim().length() > 0 ? contextWord.trim() : null), (translation.length() > 0 ? translation : null));

        contextTranslationTupleList.add(contextTranslationTuple);
        writeToFile("            " + contextTranslationTuple.contextWord + "  -->  " + contextTranslationTuple.translation);
      }
    }

    Map<String, List<String>> translation2ContextWordList = new LinkedHashMap<String, List<String>>();
    List<String> contextWordList = new ArrayList<String>();

    for(ContextTranslationTuple contextTranslationTuple : contextTranslationTupleList) {
      if(contextTranslationTuple.contextWord != null) {
        contextWordList.add(contextTranslationTuple.contextWord);
      }

      if(contextTranslationTuple.translation != null) {
        if(contextWordList.isEmpty()) {
          contextWordList = null;
        }

        translation2ContextWordList.put(contextTranslationTuple.translation, contextWordList);
        writeToFile("                " + contextTranslationTuple.translation + "  -->  " + stringJoin(contextWordList, "{ ", " }", ", "));
        contextWordList = new ArrayList<String>();
      }
    }

    if(!translation2ContextWordList.isEmpty()) {
      for(String word : wordList) {
        long wordID = saveWord(word);

        if(wordID >= 0) {
          for(Entry<String, List<String>> entry : translation2ContextWordList.entrySet()) {
            String translation = cleanupTranslation(entry.getKey());
            long translationID = saveTranslation(translation);

            writeToFile("                    " + word + "  -->  " + translation);

            if(translationID >= 0) {
              saveWordTranslation(wordID, translationID, category);

              if(entry.getValue() != null) {
                for(String contextWord : entry.getValue()) {
                  contextWord = cleanupContextWord(contextWord);

                  if(contextWord.indexOf('(') < 0) {
                    long contextWordID = saveWord(contextWord);

                    if(wordID >= 0) {
                      saveTranslationContext(translationID, contextWordID);
                    }
                  }
                  else {
                    System.err.println("Skipping context word: " + contextWord);
                  }
                }
              }

              if(keyWord2Count.containsKey(word)) {
                keyWord2Count.put(word, keyWord2Count.get(word) + 1);
              }
              else {
                keyWord2Count.put(word, new Integer(1));
              }
            }
          }
        }
      }
    }
  }


  private void processWordElement(String translationLine) {
    String[] wordElementLineArray = cleanupEmptyLines(translationLine.split(SPLIT_REGEXP__WORD_ELEMENT));
    String previousWordElementWord = null;

    for(String wordElementLine : wordElementLineArray) {
      Matcher wordElementLineMatcher = Pattern.compile(MATCH_REGEXP__WORD_ELEMENT).matcher(wordElementLine);

      if(wordElementLineMatcher.find()) {
        String word = wordElementLineMatcher.group(1).trim();
        String translationRemainder = wordElementLineMatcher.group(2).trim();

        if(!word.isEmpty()) {
          if(previousWordElementWord != null && (word.startsWith("-") || word.startsWith("―"))) {
            word = previousWordElementWord + word.substring(1);
          }

          if(!translationRemainder.isEmpty()) {
            writeToFile("        " + word + "  -->  " + translationRemainder);
            processTranslation(cleanupWord(word), translationRemainder, 0);
          }

          previousWordElementWord = word;
        }
      }
      else {
        System.err.println("Failed to match MainElement " + wordElementLine);
      }
    }
  }


  private void processMeaningElement(String translationLine) {
    Matcher meaningElementMatcher = Pattern.compile(MATCH_REGEXP__MEANING_ELEMENT).matcher(translationLine);

    if(meaningElementMatcher.find()) {
      String meaning = meaningElementMatcher.group(1).trim();
      String translationRemainder = meaningElementMatcher.group(2).trim();

      if(!meaning.isEmpty() && meaning.length() <= 50) {
        if(!translationRemainder.isEmpty()) {
          if(meaning.endsWith("(")) {
            meaning = meaning.substring(0, meaning.length() - 1);
            translationRemainder = "(" + translationRemainder;
          }

          translationRemainder = cleanupMeaningTranslation(translationRemainder);

          if(!Pattern.compile(MATCH_REGEXP__ANY_HANGUL).matcher(cleanupMeaningContext(translationRemainder)).find()) {
            writeToFile("        " + meaning + "  -->  " + translationRemainder);
            processTranslation(cleanupWord(meaning), translationRemainder, 10);
          }
        }
      }
    }
  }


  @Override
  protected void processTranslationList(String word, List<String> translationList) {
    if(word != null && word.trim().length() > 0) {
      if(++count % 1000 == 0) {
        System.out.println(count);
      }

      for(String translation : translationList) {
        if(translation != null && translation.trim().length() > 0) {
          List<String> translationSubList = getTranslationSubList(translation.trim());

          for(String subTranslation : translationSubList) {
            writeToFile(word + "  -->  " + subTranslation);
            String[] translationLineArray = cleanupTranslationLineArray(subTranslation.split(SPLIT_REGEXP__END_OF_LINE));

            for(String translationLine : translationLineArray) {
              writeToFile("    " + translationLine);

              if(translationLine.startsWith("<B>")) {
                processWordElement(translationLine);
              }
              else if(translationLine.startsWith("▶ ")) {
                processMeaningElement(translationLine);
              }
              else {
                System.err.println("Unknown line start: " + translationLine);
              }
            }

            writeToFile("");
          }
        }
      }
    }
  }


  @Override
  protected void afterTranslation() {
    Map<Integer, List<String>> count2KeyWordListTreeMap = new TreeMap<Integer, List<String>>();

    for(Entry<String, Integer> keyWord2CountEntry : keyWord2Count.entrySet()) {
      if(keyWord2CountEntry.getValue() > 5) {
        List<String> keyWordList = count2KeyWordListTreeMap.get(keyWord2CountEntry.getValue());

        if(keyWordList == null) {
          count2KeyWordListTreeMap.put(keyWord2CountEntry.getValue(), keyWordList = new ArrayList<String>());
        }

        keyWordList.add(keyWord2CountEntry.getKey());
      }
    }

    writeToFile("\n");
    writeToFile("---------------------------------------------------------------");
    writeToFile("--------------------------  SUMMARY  --------------------------");
    writeToFile("---------------------------------------------------------------");
    writeToFile("\n");

    for(Entry<Integer, List<String>> count2KeyWordListTreeEntry : count2KeyWordListTreeMap.entrySet()) {
      List<String> keyWordList = count2KeyWordListTreeEntry.getValue();
      StringBuilder builder = new StringBuilder();

      for(String keyWord : keyWordList) {
        if(builder.length() > 0) {
          builder.append(", ");
        }

        builder.append(keyWord);
      }

      writeToFile(count2KeyWordListTreeEntry.getKey() + "  -->  " + builder.toString());
    }

    super.afterTranslation();
  }


  @Override
  protected String getDbName() {
    return DB_NAME;
  }


  @Override
  protected String getOutputFileName() {
    return FILE_OUTPUT;
  }


  public static void main(String[] args) throws Exception {
    long startTime = System.currentTimeMillis();

    NaverLd2Extractor l2Extractor = new NaverLd2Extractor();
    l2Extractor.extractLd2ToFile(new File(FILE_INPUT));

    System.out.println("Done in " + ((System.currentTimeMillis() - startTime) / 1000) + "s");
  }

}
