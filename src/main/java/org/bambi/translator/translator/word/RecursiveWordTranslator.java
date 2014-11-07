package org.bambi.translator.translator.word;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import org.bambi.translator.data.AGrammarContextDO;
import org.bambi.translator.data.TranslationDataDO;
import org.bambi.translator.data.WordDataDO;
import org.bambi.translator.data.WordTranslationDO;
import org.bambi.translator.data.type.ETranslationCategory;
import org.bambi.translator.data.type.ETranslationProvider;
import org.bambi.translator.translator.helper.KoreanParticleHelper;
import org.bambi.translator.translator.helper.KoreanRomanizationHelper;


public class RecursiveWordTranslator implements IWordTranslator {

  private List<List<AGrammarContextDO>> fillGrammarContextList(String wordSuffix, List<AGrammarContextDO> grammarContextList) {
    List<List<AGrammarContextDO>> grammarContextListList = new ArrayList<List<AGrammarContextDO>>();

    if(wordSuffix.length() > 0) {
      List<String> particleList = KoreanParticleHelper.getParticleList();

      for(String particle : particleList) {
        if(wordSuffix.startsWith(particle)) {
          List<AGrammarContextDO> newGrammarContextList = new ArrayList<AGrammarContextDO>(grammarContextList);
          newGrammarContextList.add(KoreanParticleHelper.getParticleGrammarContext(particle));

          grammarContextListList.addAll(fillGrammarContextList(wordSuffix.substring(particle.length()), newGrammarContextList));
        }
      }
    }
    else {
      grammarContextListList.add(grammarContextList);
    }

    return grammarContextListList;
  }


  private TranslationDataDO createTranslationData(String wordFragment, String romanizedTranslation, List<AGrammarContextDO> grammarContextList) {
    TranslationDataDO translationData = new TranslationDataDO();

    translationData.setWord(wordFragment);
    translationData.setWordFlat(wordFragment);
    translationData.setTranslation(romanizedTranslation);
    translationData.setGrammarContextList(grammarContextList);
    translationData.setProvider(ETranslationProvider.NONE);

    return translationData;
  }


  private TranslationDataDO createTranslationData(WordTranslationDO wordTranslation, List<AGrammarContextDO> grammarContextList) {
    TranslationDataDO translationData = new TranslationDataDO();

    translationData.setWord(wordTranslation.getWord());
    translationData.setWordFlat(wordTranslation.getWordFlat());
    translationData.setTranslation(wordTranslation.getTranslation());
    translationData.setCategory(ETranslationCategory.fromDbValue(wordTranslation.getCategory()));
    translationData.setOrder(wordTranslation.getPriority());
    translationData.setGrammarContextList(grammarContextList);
    translationData.setProvider(translatorDatabase.getTranslationProvider());

    return translationData;
  }


  private void fillDatabaseTranslation(List<TranslationDataDO> translationDataList, String wordFragment,
      List<List<AGrammarContextDO>> grammarContextListList) {

    List<WordTranslationDO> wordTranslationsList = translatorDatabase.findTranslationsByWordFlat(wordFragment);

    if(CollectionUtils.isNotEmpty(wordTranslationsList)) {
      for(WordTranslationDO wordTranslation : wordTranslationsList) {
        if(CollectionUtils.isNotEmpty(grammarContextListList)) {
          for(List<AGrammarContextDO> grammarContextList : grammarContextListList) {
            translationDataList.add(createTranslationData(wordTranslation, grammarContextList));
          }
        }
        else {
          translationDataList.add(createTranslationData(wordTranslation, null));
        }
      }
    }
  }


  protected void translate(WordDataDO wordData, int index) {
    if(index > 0) {
      List<TranslationDataDO> translationDataList = wordData.getTranslationDataList();
      String word = wordData.getWord();
      boolean fragment = (index < word.length());

      String wordFragment = word.substring(0, index);
      String wordSuffix = (fragment ? word.substring(index) : "");

      List<List<AGrammarContextDO>> grammarContextListList = fillGrammarContextList(wordSuffix, new ArrayList<AGrammarContextDO>());

      if(!fragment || CollectionUtils.isNotEmpty(grammarContextListList)) {
        String romanizedTranslation = KoreanRomanizationHelper.getDictionaryTranslation(wordFragment);

        if(romanizedTranslation == null) {
          romanizedTranslation = KoreanRomanizationHelper.getRomanizedTranslation(wordFragment);
        }

        if(romanizedTranslation != null) {
          if(CollectionUtils.isNotEmpty(grammarContextListList)) {
            for(List<AGrammarContextDO> grammarContextList : grammarContextListList) {
              translationDataList.add(createTranslationData(wordFragment, romanizedTranslation, grammarContextList));
            }
          }
          else {
            translationDataList.add(createTranslationData(wordFragment, romanizedTranslation, null));
          }
        }

        fillDatabaseTranslation(translationDataList, wordFragment, grammarContextListList);
      }
      else {
        fillDatabaseTranslation(translationDataList, wordFragment, null);
      }

      translate(wordData, index - 1);
    }
  }


  public void translate(WordDataDO wordData) {
    if(wordData.getWord() != null) {
      translate(wordData, wordData.getWord().length());
    }
  }

}
