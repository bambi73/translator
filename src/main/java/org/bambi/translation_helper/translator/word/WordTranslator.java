package org.bambi.translation_helper.translator.word;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import org.bambi.translation_helper.data.AGrammarContextDO;
import org.bambi.translation_helper.data.GrammarContextContainerDO;
import org.bambi.translation_helper.data.TranslationContainerDO;
import org.bambi.translation_helper.data.TranslationDataDO;
import org.bambi.translation_helper.data.WordDataDO;
import org.bambi.translation_helper.data.WordTranslationDO;
import org.bambi.translation_helper.data.type.EGrammarContextType;
import org.bambi.translation_helper.data.type.ETranslationType;
import org.bambi.translation_helper.database.ITranslatorDatabase;
import org.bambi.translation_helper.translator.helper.KoreanParticleHelper;
import org.bambi.translation_helper.translator.helper.KoreanRomanizationHelper;
import org.bambi.translation_helper.utils.Utils;


public class WordTranslator implements IWordTranslator {

  protected ITranslatorDatabase translatorDatabase = null;
  
  
  public WordTranslator(ITranslatorDatabase translatorDatabase) {
    this.translatorDatabase = translatorDatabase;
  }
  
  
  private List<TranslationDataDO> getTranslationDataList(WordDataDO wordData, ETranslationType translationType) {
    TranslationContainerDO translationContainer = wordData.getTranslationContainerDO(translationType);
    return translationContainer.getTranslationDataList(translatorDatabase.getTranslatorProvider());
  }


  private List<WordTranslationDO> getWordTranslationList(String wordFragment, ETranslationType translationType) {
    List<WordTranslationDO> wordTranslationList = null;
    
    if(translationType == ETranslationType.ROMANIZATION) {
      wordTranslationList = KoreanRomanizationHelper.getRomanizedWordTranslationList(wordFragment);
    }
    else {
      wordTranslationList = translatorDatabase.findTranslationsByWordFlat(wordFragment);
    }

    return wordTranslationList;
  }

  
  private boolean translateWord(WordDataDO wordData, String word, ETranslationType translationType) {
    List<TranslationDataDO> translationDataList = getTranslationDataList(wordData, translationType);
    List<WordTranslationDO> wordTranslationList = getWordTranslationList(word, translationType);

    if(CollectionUtils.isNotEmpty(wordTranslationList)) {
      for(WordTranslationDO wordTranslation : wordTranslationList) {
        TranslationDataDO translationData = new TranslationDataDO(wordTranslation);
        translationDataList.add(translationData);
      }

      return true;
    }
    else {
      return false;
    }
  }


  private boolean translateDirect(WordDataDO wordData) {
    return translateWord(wordData, wordData.getWord(), ETranslationType.DIRECT);
  }


  private boolean translateRecursive(WordDataDO wordData, String wordFragment, boolean stopOnMatch) {
    boolean match = false;

    if(StringUtils.isNotEmpty(wordFragment)) {
      match |= translateWord(wordData, wordFragment, ETranslationType.RECURSIVE);

      if(!match || !stopOnMatch) {
        match |= translateRecursive(wordData, Utils.stripLastCharacter(wordFragment), stopOnMatch);
      }
    }

    return match;
  }

  
  private boolean translateParticle(
      String wordFragment, List<TranslationDataDO> translationDataList, List<AGrammarContextDO> grammarContextList,  
      ETranslationType translationType) {
    
    boolean match = false;

    if(StringUtils.isNotEmpty(wordFragment)) {
      List<String> particleList = KoreanParticleHelper.getParticleList();
      
      if(CollectionUtils.isNotEmpty(grammarContextList)) {
        List<WordTranslationDO> wordTranslationList = getWordTranslationList(wordFragment, translationType);

        if(CollectionUtils.isNotEmpty(wordTranslationList)) {
          GrammarContextContainerDO grammarContextContainer = new GrammarContextContainerDO(EGrammarContextType.PARTICLE);
          grammarContextContainer.getGrammarContextList().addAll(grammarContextList);
          
          for(WordTranslationDO wordTranslation : wordTranslationList) {
            TranslationDataDO translationData = new TranslationDataDO(wordTranslation);
            translationData.setGrammarContextContainer(grammarContextContainer);
            
            translationDataList.add(translationData);
          }
          
          match |= true;
        }
      }
      
      for(String particle : particleList) {
        if(wordFragment.endsWith(particle)) {
          List<AGrammarContextDO> newGrammarContextList = new ArrayList<AGrammarContextDO>();
          newGrammarContextList.add(KoreanParticleHelper.getParticleGrammarContext(particle));
          newGrammarContextList.addAll(grammarContextList);
          
          match |= translateParticle(Utils.stripCharacters(
              wordFragment, particle.length()), translationDataList, newGrammarContextList, translationType);
        }
      }
    }
  
    return match;
  }


  private boolean translateParticle(WordDataDO wordData) {
    List<TranslationDataDO> translationDataList = getTranslationDataList(wordData, ETranslationType.PARTICLE);
    return translateParticle(wordData.getWord(), translationDataList, new ArrayList<AGrammarContextDO>(), ETranslationType.PARTICLE);
  }

  
  private boolean translateRomanization(WordDataDO wordData) { 
    List<TranslationDataDO> translationDataList = getTranslationDataList(wordData, ETranslationType.ROMANIZATION);
    boolean match = translateWord(wordData, wordData.getWord(), ETranslationType.ROMANIZATION);;
    return match | translateParticle(wordData.getWord(), translationDataList, new ArrayList<AGrammarContextDO>(), ETranslationType.ROMANIZATION);
  }
    

  public boolean translate(ETranslationType translationType, WordDataDO wordData) {
    if(wordData.getWord() != null) {
      switch(translationType) {
        case DIRECT: 
          return translateDirect(wordData);
      
        case RECURSIVE: 
          return translateRecursive(wordData, Utils.stripLastCharacter(wordData.getWord()), true);
          
        case PARTICLE:
          return translateParticle(wordData);
          
        case ROMANIZATION:
          return translateRomanization(wordData);
      }
    }
    
    return false;
  }

}
