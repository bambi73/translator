package org.bambi.translation_helper.translator.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bambi.translation_helper.data.ParticleGrammarContextDO;

public class KoreanParticleHelper {

  public static final String PARTICLE_HANGUL__NEUN = "는";
  public static final String PARTICLE_HANGUL__GA = "가";
  public static final String PARTICLE_HANGUL__GE = "게";
  public static final String PARTICLE_HANGUL__GWA = "과";
  public static final String PARTICLE_HANGUL__KKAJI = "까지";
  public static final String PARTICLE_HANGUL__KKE = "께";
  public static final String PARTICLE_HANGUL__KKESEO = "께서";
  public static final String PARTICLE_HANGUL__DO = "도";
  public static final String PARTICLE_HANGUL__DEUN = "든";
  public static final String PARTICLE_HANGUL__DEUL = "들";
  public static final String PARTICLE_HANGUL__RANG = "랑";
  public static final String PARTICLE_HANGUL__RO = "로";
  public static final String PARTICLE_HANGUL__REUL = "를";
  public static final String PARTICLE_HANGUL__MANKEUM = "만큼";
  public static final String PARTICLE_HANGUL__BODA = "보다";
  public static final String PARTICLE_HANGUL__BUTEO = "부터";
  public static final String PARTICLE_HANGUL__PPUN = "뿐";
  public static final String PARTICLE_HANGUL__SEO = "서";
  public static final String PARTICLE_HANGUL__E = "에";
  public static final String PARTICLE_HANGUL__EGE = "에게";
  public static final String PARTICLE_HANGUL__EDA = "에다";
  public static final String PARTICLE_HANGUL__ESEO = "에서";
  public static final String PARTICLE_HANGUL__WA = "와";
  public static final String PARTICLE_HANGUL__YO = "요";
  public static final String PARTICLE_HANGUL__EURO = "으로";
  public static final String PARTICLE_HANGUL__EUN = "은";
  public static final String PARTICLE_HANGUL__EUL = "을";
  public static final String PARTICLE_HANGUL__UI = "의";
  public static final String PARTICLE_HANGUL__I = "이";
  public static final String PARTICLE_HANGUL__IDA = "이다";
  public static final String PARTICLE_HANGUL__IRA = "이라";
  public static final String PARTICLE_HANGUL__IRANG = "이랑";
  public static final String PARTICLE_HANGUL__IMYEO = "이며";
  public static final String PARTICLE_HANGUL__JI = "지";
  public static final String PARTICLE_HANGUL__CHEOREOM = "처럼";
  public static final String PARTICLE_HANGUL__HAGO = "하고";
  public static final String PARTICLE_HANGUL__HANTE = "한테";

  
  public static final String PARTICLE_SHORT_DESCRIPTION__NEUN = "Topic";
  public static final String PARTICLE_SHORT_DESCRIPTION__GA = "Subject (podmet)";
  public static final String PARTICLE_SHORT_DESCRIPTION__GE = "Dative (3.pad)";
  public static final String PARTICLE_SHORT_DESCRIPTION__GWA = "{And; With; In relation to}";
  public static final String PARTICLE_SHORT_DESCRIPTION__KKAJI = "{Until; Till; Up to}";
  public static final String PARTICLE_SHORT_DESCRIPTION__KKE = "Dative (3.pad)";
  public static final String PARTICLE_SHORT_DESCRIPTION__KKESEO = "Subject (podmet)";
  public static final String PARTICLE_SHORT_DESCRIPTION__DO = "{Too; As well; Either}";
  public static final String PARTICLE_SHORT_DESCRIPTION__DEUN = "Additive";
  public static final String PARTICLE_SHORT_DESCRIPTION__DEUL = "Plural";
  public static final String PARTICLE_SHORT_DESCRIPTION__RANG = "{And; With}";
  public static final String PARTICLE_SHORT_DESCRIPTION__RO = "Instrumental (7.pad)";
  public static final String PARTICLE_SHORT_DESCRIPTION__REUL = "Direct object";
  public static final String PARTICLE_SHORT_DESCRIPTION__MANKEUM = "{Extent to which}";
  public static final String PARTICLE_SHORT_DESCRIPTION__BODA = "{Than; Rather than}";
  public static final String PARTICLE_SHORT_DESCRIPTION__BUTEO = "Action start";
  public static final String PARTICLE_SHORT_DESCRIPTION__PPUN = "{Only; Just}";
  public static final String PARTICLE_SHORT_DESCRIPTION__SEO = "{From; In; At; On}";
  public static final String PARTICLE_SHORT_DESCRIPTION__E = "Time/Place";
  public static final String PARTICLE_SHORT_DESCRIPTION__EGE = "Dative (3.pad)";
  public static final String PARTICLE_SHORT_DESCRIPTION__EDA = "{(To be) at}";
  public static final String PARTICLE_SHORT_DESCRIPTION__ESEO = "Location/Place";
  public static final String PARTICLE_SHORT_DESCRIPTION__WA = "{And; With; In relation to}";
  public static final String PARTICLE_SHORT_DESCRIPTION__YO = "Sentence end";
  public static final String PARTICLE_SHORT_DESCRIPTION__EURO = "Instrumental (7.pad)";
  public static final String PARTICLE_SHORT_DESCRIPTION__EUN = "Topic";
  public static final String PARTICLE_SHORT_DESCRIPTION__EUL = "Direct object";
  public static final String PARTICLE_SHORT_DESCRIPTION__UI = "Possession";
  public static final String PARTICLE_SHORT_DESCRIPTION__I = "Subject (podmet)";
  public static final String PARTICLE_SHORT_DESCRIPTION__IDA = "Positive copula";
  public static final String PARTICLE_SHORT_DESCRIPTION__IRA = "Indirect quote";
  public static final String PARTICLE_SHORT_DESCRIPTION__IRANG = "{And; With}";
  public static final String PARTICLE_SHORT_DESCRIPTION__IMYEO = "Connection";
  public static final String PARTICLE_SHORT_DESCRIPTION__JI = "{Whether}";
  public static final String PARTICLE_SHORT_DESCRIPTION__CHEOREOM = "{Like, As, As if}";
  public static final String PARTICLE_SHORT_DESCRIPTION__HAGO = "{And; With}";
  public static final String PARTICLE_SHORT_DESCRIPTION__HANTE = "{To; At; For; By; From}";

  
  public static final String PARTICLE_LONG_DESCRIPTION__NEUN = 
      "1. Marks the topic of the sentence. The topic of a sentence is not to be confused with the subject of the sentence.\n" +
      "2. Depending on context, shows contrast with or adds emphasis to the preceding word or phrase in a sentence.";
  public static final String PARTICLE_LONG_DESCRIPTION__GA = 
      "1. Indicates the subject of a sentence.\n" + 
      "2. Indicates the subjective complement of a sentence, usually used with 되다(doeda, become) or 아니다(anida, be not).";
  public static final String PARTICLE_LONG_DESCRIPTION__GE = 
      "1. A shortened form of the dative particle 에게 (ege); to, (for, by)";
  public static final String PARTICLE_LONG_DESCRIPTION__GWA = 
      "1. And\n" +
      "2. With; Together with\n" + 
      "3. In relation to";
  public static final String PARTICLE_LONG_DESCRIPTION__KKAJI = 
      "1. A special particle (보조사, bojosa) generally meaning until, till, by (a time), up to. 까지 (ggaji) can be used in three situations.\n" +
      "   - To illustrate the extent of a finished action or situation.\n" +
      "   - To illustrate to what extent an action will continue.\n" +
      "   - To illustrate the degree or intensity of a situation.";
  public static final String PARTICLE_LONG_DESCRIPTION__KKE = 
      "1. The honorific dative particle; meaning To, By, For.";
  public static final String PARTICLE_LONG_DESCRIPTION__KKESEO = 
      "1. The honorific subject of a sentence.";
  public static final String PARTICLE_LONG_DESCRIPTION__DO = 
      "1. As well; too; either, or (negative) neither, nor\n" +
      "2. Even";
  public static final String PARTICLE_LONG_DESCRIPTION__DEUN = 
      "1. Used for enumeration, suggests that which one is selected does not matter.";
  public static final String PARTICLE_LONG_DESCRIPTION__DEUL = 
      "1. Indicating the plural of a noun.";
  public static final String PARTICLE_LONG_DESCRIPTION__RANG = 
      "1. Colloquial And, With";
  public static final String PARTICLE_LONG_DESCRIPTION__RO = 
      "1. By means of\n" +
      "2. According to\n" +
      "3. By (a specified date/time)\n" +
      "4. Because of\n" +
      "5. Toward\n" +
      "6. With\n" +
      "7. As";
  public static final String PARTICLE_LONG_DESCRIPTION__REUL = 
      "1. Indicates the direct object of a verb.";
  public static final String PARTICLE_LONG_DESCRIPTION__MANKEUM = 
      "1. Like; As; As...as; So...as; Not so ...as; Less...than\n" +
      "2. So...that; So...as to; Enough...to";
  public static final String PARTICLE_LONG_DESCRIPTION__BODA = 
      "1. Than, Rather than.";
  public static final String PARTICLE_LONG_DESCRIPTION__BUTEO = 
      "1. To illustrate the time that a certain action or situation began or will begin. Equates to \"(start) from\" or \"(start) at\" in English.\n" +
      "2. To illustrate the place that a certain action began or will begin. Equates to \"from\" in English. Can be used after 에서 (eseo) 로 (ro) also together meaning \"from\".\n" + 
      "3. To illustrate an order of a series of actions.";
  public static final String PARTICLE_LONG_DESCRIPTION__PPUN = 
      "1. Only; Nothing more than\n" + 
      "2. Just";
  public static final String PARTICLE_LONG_DESCRIPTION__SEO = 
      "1. From\n" +
      "2. In; At; On";
  public static final String PARTICLE_LONG_DESCRIPTION__E = 
      "1. At\n" +
      "2. To";
  public static final String PARTICLE_LONG_DESCRIPTION__EGE = 
      "1. The dative particle; To";
  public static final String PARTICLE_LONG_DESCRIPTION__EDA = 
      "1. (To be) at";
  public static final String PARTICLE_LONG_DESCRIPTION__ESEO = "";
  public static final String PARTICLE_LONG_DESCRIPTION__WA = "";
  public static final String PARTICLE_LONG_DESCRIPTION__YO = "";
  public static final String PARTICLE_LONG_DESCRIPTION__EURO = "";
  public static final String PARTICLE_LONG_DESCRIPTION__EUN = "";
  public static final String PARTICLE_LONG_DESCRIPTION__EUL = "";
  public static final String PARTICLE_LONG_DESCRIPTION__UI = "";
  public static final String PARTICLE_LONG_DESCRIPTION__I = "";
  public static final String PARTICLE_LONG_DESCRIPTION__IDA = "";
  public static final String PARTICLE_LONG_DESCRIPTION__IRA = "";
  public static final String PARTICLE_LONG_DESCRIPTION__IRANG = "";
  public static final String PARTICLE_LONG_DESCRIPTION__IMYEO = "";
  public static final String PARTICLE_LONG_DESCRIPTION__JI = "";
  public static final String PARTICLE_LONG_DESCRIPTION__CHEOREOM = "";
  public static final String PARTICLE_LONG_DESCRIPTION__HAGO = "";
  public static final String PARTICLE_LONG_DESCRIPTION__HANTE = "";

  
  private static final Map<String, ParticleGrammarContextDO> particle2Description = new HashMap<String, ParticleGrammarContextDO>();
  private static final List<String> particleList = new ArrayList<String>();
  
  private static int maxParticleLength;
  
  
  static {
    particle2Description.put(
        PARTICLE_HANGUL__NEUN, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__NEUN, PARTICLE_SHORT_DESCRIPTION__NEUN, PARTICLE_LONG_DESCRIPTION__NEUN));
    particle2Description.put(
        PARTICLE_HANGUL__GA, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__GA, PARTICLE_SHORT_DESCRIPTION__GA, PARTICLE_LONG_DESCRIPTION__GA));
    particle2Description.put(
        PARTICLE_HANGUL__GE, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__GE, PARTICLE_SHORT_DESCRIPTION__GE, PARTICLE_LONG_DESCRIPTION__GE));
    particle2Description.put(
        PARTICLE_HANGUL__GWA, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__GWA, PARTICLE_SHORT_DESCRIPTION__GWA, PARTICLE_LONG_DESCRIPTION__GWA));
    particle2Description.put(
        PARTICLE_HANGUL__KKAJI, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__KKAJI, PARTICLE_SHORT_DESCRIPTION__KKAJI, PARTICLE_LONG_DESCRIPTION__KKAJI));
    particle2Description.put(
        PARTICLE_HANGUL__KKE, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__KKE, PARTICLE_SHORT_DESCRIPTION__KKE, PARTICLE_LONG_DESCRIPTION__KKE));
    particle2Description.put(
        PARTICLE_HANGUL__KKESEO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__KKESEO, PARTICLE_SHORT_DESCRIPTION__KKESEO, PARTICLE_LONG_DESCRIPTION__KKESEO));
    particle2Description.put(
        PARTICLE_HANGUL__DO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__DO, PARTICLE_SHORT_DESCRIPTION__DO, PARTICLE_LONG_DESCRIPTION__DO));
    particle2Description.put(
        PARTICLE_HANGUL__DEUN, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__DEUN, PARTICLE_SHORT_DESCRIPTION__DEUN, PARTICLE_LONG_DESCRIPTION__DEUN));
    particle2Description.put(
        PARTICLE_HANGUL__DEUL, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__DEUL, PARTICLE_SHORT_DESCRIPTION__DEUL, PARTICLE_LONG_DESCRIPTION__DEUL));
    particle2Description.put(
        PARTICLE_HANGUL__RANG, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__RANG, PARTICLE_SHORT_DESCRIPTION__RANG, PARTICLE_LONG_DESCRIPTION__RANG));
    particle2Description.put(
        PARTICLE_HANGUL__RO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__RO, PARTICLE_SHORT_DESCRIPTION__RO, PARTICLE_LONG_DESCRIPTION__RO));
    particle2Description.put(
        PARTICLE_HANGUL__REUL, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__REUL, PARTICLE_SHORT_DESCRIPTION__REUL, PARTICLE_LONG_DESCRIPTION__REUL));
    particle2Description.put(
        PARTICLE_HANGUL__MANKEUM, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__MANKEUM, PARTICLE_SHORT_DESCRIPTION__MANKEUM, PARTICLE_LONG_DESCRIPTION__MANKEUM));
    particle2Description.put(
        PARTICLE_HANGUL__BODA, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__BODA, PARTICLE_SHORT_DESCRIPTION__BODA, PARTICLE_LONG_DESCRIPTION__BODA));
    particle2Description.put(
        PARTICLE_HANGUL__BUTEO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__BUTEO, PARTICLE_SHORT_DESCRIPTION__BUTEO, PARTICLE_LONG_DESCRIPTION__BUTEO));
    particle2Description.put(
        PARTICLE_HANGUL__PPUN, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__PPUN, PARTICLE_SHORT_DESCRIPTION__PPUN, PARTICLE_LONG_DESCRIPTION__PPUN));
    particle2Description.put(
        PARTICLE_HANGUL__SEO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__SEO, PARTICLE_SHORT_DESCRIPTION__SEO, PARTICLE_LONG_DESCRIPTION__SEO));
    particle2Description.put(
        PARTICLE_HANGUL__E, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__E, PARTICLE_SHORT_DESCRIPTION__E, PARTICLE_LONG_DESCRIPTION__E));
    particle2Description.put(
        PARTICLE_HANGUL__EGE, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__EGE, PARTICLE_SHORT_DESCRIPTION__EGE, PARTICLE_LONG_DESCRIPTION__EGE));
    particle2Description.put(
        PARTICLE_HANGUL__EDA, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__EDA, PARTICLE_SHORT_DESCRIPTION__EDA, PARTICLE_LONG_DESCRIPTION__EDA));
    particle2Description.put(
        PARTICLE_HANGUL__ESEO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__ESEO, PARTICLE_SHORT_DESCRIPTION__ESEO, PARTICLE_LONG_DESCRIPTION__ESEO));
    particle2Description.put(
        PARTICLE_HANGUL__WA, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__WA, PARTICLE_SHORT_DESCRIPTION__WA, PARTICLE_LONG_DESCRIPTION__WA));
    particle2Description.put(
        PARTICLE_HANGUL__YO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__YO, PARTICLE_SHORT_DESCRIPTION__YO, PARTICLE_LONG_DESCRIPTION__YO));
    particle2Description.put(
        PARTICLE_HANGUL__EURO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__EURO, PARTICLE_SHORT_DESCRIPTION__EURO, PARTICLE_LONG_DESCRIPTION__EURO));
    particle2Description.put(
        PARTICLE_HANGUL__EUN, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__EUN, PARTICLE_SHORT_DESCRIPTION__EUN, PARTICLE_LONG_DESCRIPTION__EUN));
    particle2Description.put(
        PARTICLE_HANGUL__EUL, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__EUL, PARTICLE_SHORT_DESCRIPTION__EUL, PARTICLE_LONG_DESCRIPTION__EUL));
    particle2Description.put(
        PARTICLE_HANGUL__UI, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__UI, PARTICLE_SHORT_DESCRIPTION__UI, PARTICLE_LONG_DESCRIPTION__UI));
    particle2Description.put(
        PARTICLE_HANGUL__I, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__I, PARTICLE_SHORT_DESCRIPTION__I, PARTICLE_LONG_DESCRIPTION__I));
    particle2Description.put(
        PARTICLE_HANGUL__IDA, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__IDA, PARTICLE_SHORT_DESCRIPTION__IDA, PARTICLE_LONG_DESCRIPTION__IDA));
    particle2Description.put(
        PARTICLE_HANGUL__IRA, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__IRA, PARTICLE_SHORT_DESCRIPTION__IRA, PARTICLE_LONG_DESCRIPTION__IRA));
    particle2Description.put(
        PARTICLE_HANGUL__IRANG, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__IRANG, PARTICLE_SHORT_DESCRIPTION__IRANG, PARTICLE_LONG_DESCRIPTION__IRANG));
    particle2Description.put(
        PARTICLE_HANGUL__IMYEO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__IMYEO, PARTICLE_SHORT_DESCRIPTION__IMYEO, PARTICLE_LONG_DESCRIPTION__IMYEO));
    particle2Description.put(
        PARTICLE_HANGUL__CHEOREOM, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__CHEOREOM, PARTICLE_SHORT_DESCRIPTION__CHEOREOM, PARTICLE_LONG_DESCRIPTION__CHEOREOM));
    particle2Description.put(
        PARTICLE_HANGUL__HAGO, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__HAGO, PARTICLE_SHORT_DESCRIPTION__HAGO, PARTICLE_LONG_DESCRIPTION__HAGO));
    particle2Description.put(
        PARTICLE_HANGUL__HANTE, 
        new ParticleGrammarContextDO(PARTICLE_HANGUL__HANTE, PARTICLE_SHORT_DESCRIPTION__HANTE, PARTICLE_LONG_DESCRIPTION__HANTE));
  
    maxParticleLength = 0;
    
    for(String particle : particle2Description.keySet()) {
      maxParticleLength = Math.max(maxParticleLength, particle.length());
      particleList.add(particle);
    }
  }

  
  public static ParticleGrammarContextDO getParticleGrammarContext(String particle) { 
    return particle2Description.get(particle);
  }

  
  public static List<String> getParticleList() {
    return particleList;
  }
  

  public static int getMaxParticleLength() {
    return maxParticleLength;
  }

}
