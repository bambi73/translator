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
import org.bambi.translator.database.ITranslatorDatabase;
import org.bambi.translator.translator.helper.KoreanParticleHelper;
import org.bambi.translator.translator.helper.KoreanRomanizationHelper;


public class DatabaseWordTranslator extends RecursiveWordTranslator {

  protected ITranslatorDatabase translatorDatabase = null;

  
  public DatabaseWordTranslator(ITranslatorDatabase translatorDatabase) {
    this.translatorDatabase = translatorDatabase;
  }

  
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
  
  
  private void fillDatabaseTranslation(
      List<TranslationDataDO> translationDataList, String wordFragment, List<List<AGrammarContextDO>> grammarContextListList) {
  
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


//  public WordTranslator(ITranslatorDatabase translatorDatabase) {
//    this.translatorDatabase = translatorDatabase;
//  }
//
//
//  private List<TranslationDataDO> getTranslationDataList(WordDataDO wordData, ETranslationType translationType) {
//    TranslationContainerDO translationContainer = wordData.getTranslationContainerDO(translationType);
//    return translationContainer.getTranslationDataList(translatorDatabase.getTranslatorProvider());
//  }
//
//
//  private List<WordTranslationDO> getWordTranslationList(String wordFragment, ETranslationType translationType) {
//    List<WordTranslationDO> wordTranslationList = null;
//
//    if(translationType == ETranslationType.ROMANIZATION) {
//      wordTranslationList = KoreanRomanizationHelper.getRomanizedWordTranslationList(wordFragment);
//    }
//    else {
//      wordTranslationList = translatorDatabase.findTranslationsByWordFlat(wordFragment);
//    }
//
//    return wordTranslationList;
//  }
//
//
//  private boolean translateWord(WordDataDO wordData, String word, ETranslationType translationType) {
//    List<TranslationDataDO> translationDataList = getTranslationDataList(wordData, translationType);
//    List<WordTranslationDO> wordTranslationList = getWordTranslationList(word, translationType);
//
//    if(CollectionUtils.isNotEmpty(wordTranslationList)) {
//      for(WordTranslationDO wordTranslation : wordTranslationList) {
//        TranslationDataDO translationData = new TranslationDataDO(wordTranslation);
//        translationDataList.add(translationData);
//      }
//
//      return true;
//    }
//    else {
//      return false;
//    }
//  }
//
//
//  private boolean translateDirect(WordDataDO wordData) {
//    return translateWord(wordData, wordData.getWord(), ETranslationType.DIRECT);
//  }
//
//
//  private boolean translateRecursive(WordDataDO wordData, String wordFragment, boolean stopOnMatch) {
//    boolean match = false;
//
//    if(StringUtils.isNotEmpty(wordFragment)) {
//      match |= translateWord(wordData, wordFragment, ETranslationType.RECURSIVE);
//
//      if(!match || !stopOnMatch) {
//        match |= translateRecursive(wordData, Utils.stripLastCharacter(wordFragment), stopOnMatch);
//      }
//    }
//
//    return match;
//  }
//
//
//  private boolean translateParticle(String wordFragment, List<TranslationDataDO> translationDataList, List<AGrammarContextDO> grammarContextList,
//      ETranslationType translationType) {
//
//    boolean match = false;
//
//    if(StringUtils.isNotEmpty(wordFragment)) {
//      List<String> particleList = KoreanParticleHelper.getParticleList();
//
//      if(CollectionUtils.isNotEmpty(grammarContextList)) {
//        List<WordTranslationDO> wordTranslationList = getWordTranslationList(wordFragment, translationType);
//
//        if(CollectionUtils.isNotEmpty(wordTranslationList)) {
//          GrammarContextContainerDO grammarContextContainer = new GrammarContextContainerDO(EGrammarContextType.PARTICLE);
//          grammarContextContainer.getGrammarContextList().addAll(grammarContextList);
//
//          for(WordTranslationDO wordTranslation : wordTranslationList) {
//            TranslationDataDO translationData = new TranslationDataDO(wordTranslation);
//            translationData.setGrammarContextContainer(grammarContextContainer);
//
//            translationDataList.add(translationData);
//          }
//
//          match |= true;
//        }
//      }
//
//      for(String particle : particleList) {
//        if(wordFragment.endsWith(particle)) {
//          List<AGrammarContextDO> newGrammarContextList = new ArrayList<AGrammarContextDO>();
//          newGrammarContextList.add(KoreanParticleHelper.getParticleGrammarContext(particle));
//          newGrammarContextList.addAll(grammarContextList);
//
//          match |= translateParticle(Utils.stripCharacters(wordFragment, particle.length()), translationDataList, newGrammarContextList,
//              translationType);
//        }
//      }
//    }
//
//    return match;
//  }
//
//
//  private boolean translateParticle(WordDataDO wordData) {
//    List<TranslationDataDO> translationDataList = getTranslationDataList(wordData, ETranslationType.PARTICLE);
//    return translateParticle(wordData.getWord(), translationDataList, new ArrayList<AGrammarContextDO>(), ETranslationType.PARTICLE);
//  }
//
//
//  private boolean translateRomanization(WordDataDO wordData) {
//    List<TranslationDataDO> translationDataList = getTranslationDataList(wordData, ETranslationType.ROMANIZATION);
//    boolean match = translateWord(wordData, wordData.getWord(), ETranslationType.ROMANIZATION);;
//    return match | translateParticle(wordData.getWord(), translationDataList, new ArrayList<AGrammarContextDO>(), ETranslationType.ROMANIZATION);
//  }
//
//
//  public boolean translate(ETranslationType translationType, WordDataDO wordData) {
//    if(wordData.getWord() != null) {
//      switch(translationType) {
//      case DIRECT:
//        return translateDirect(wordData);
//
//      case RECURSIVE:
//        return translateRecursive(wordData, Utils.stripLastCharacter(wordData.getWord()), true);
//
//      case PARTICLE:
//        return translateParticle(wordData);
//
//      case ROMANIZATION:
//        return translateRomanization(wordData);
//      }
//    }
//
//    return false;
//  }

}
