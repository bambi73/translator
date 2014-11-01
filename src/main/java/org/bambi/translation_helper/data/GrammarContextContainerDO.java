package org.bambi.translation_helper.data;

import java.util.ArrayList;
import java.util.List;

import org.bambi.translation_helper.data.type.EGrammarContextType;


public class GrammarContextContainerDO {

  private EGrammarContextType grammarContextType = null;
  private List<AGrammarContextDO> grammarContextList = new ArrayList<AGrammarContextDO>();


  public GrammarContextContainerDO(EGrammarContextType grammarContextType) {
    this.grammarContextType = grammarContextType;
  }


  public EGrammarContextType getGrammarContextType() {
    return grammarContextType;
  }


  public List<AGrammarContextDO> getGrammarContextList() {
    return grammarContextList;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    
    for(AGrammarContextDO grammarContext : grammarContextList) {
      if(builder.length() > 0) {
        builder.append("\n");
      }
        
      builder.append("        ").append(grammarContext);
    }
    
    return builder.toString();
  }

}
