package org.bambi.translator;

import org.bambi.translator.data.SentenceContainerDO;
import org.bambi.translator.translator.sentence.NaverWordByWordSentenceTranslator;

public class Main {

  public static void main(String[] args) {
//    Main main = new Main();
    
    SentenceContainerDO sentenceContainer1 = new SentenceContainerDO(
        "현재 로열 로드라면 5년, 아니 10년이 되어도 우리 가족을 먹여 살릴 수 있다. 혜연이를 대학에도 보낼 수 있겠지." +
        "그러려면 무엇보다 안정적이어야 해. 나는 고등학교에서 끝났지만 내 동생만큼은");
    
//    SentenceContainerDO sentenceContainer1 = new SentenceContainerDO("모든 역량을 동원해서 우리의 행사를 방해한 자를 죽여라.");
//    SentenceContainerDO sentenceContainer2 = new SentenceContainerDO("그리고 그가 가져간 마탈로스트 교단의 물건들을 반드시 회수하라.");
    
//    System.err.println(Junidecode.unidecode("위드는 계곡가에 쌓여 있는 바위들을 보며 만족스러운 미소를 지었다."));
    
    NaverWordByWordSentenceTranslator sentenceTranslator = new NaverWordByWordSentenceTranslator();
    sentenceTranslator.translate(sentenceContainer1);
//    System.err.println();
//    System.err.println("################################");
//    System.err.println();
//    sentenceTranslator.translate(sentenceContainer2);

    
//    IWordTranslator naverTranslator = new NaverWordTranslator();
//    naverTranslator.translate("경험");
    
//    
    
    
    

  }

}
