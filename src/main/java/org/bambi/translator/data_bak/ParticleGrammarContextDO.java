package org.bambi.translator.data_bak;

public class ParticleGrammarContextDO extends AGrammarContextDO {

  private String hangul = null;
  private String shortDescription = null;
  private String longDescription = null;


  public ParticleGrammarContextDO(String hangul, String shortDescription, String longDescription) {
    this.hangul = hangul;
    this.shortDescription = shortDescription;
    this.longDescription = longDescription;
  }


  @Override
  public String getShortDescription() {
    return hangul + ": " + shortDescription;
  }


  @Override
  public String getTooltipDescription() {
    return longDescription;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    
    builder.append("ParticleGrammarContextDO [hangul=").append(hangul).append(", ");
    builder.append("shortDescription=").append(shortDescription).append(", ");
    builder.append("longDescription=").append(longDescription).append("]");
    
    return builder.toString();
  }

}
