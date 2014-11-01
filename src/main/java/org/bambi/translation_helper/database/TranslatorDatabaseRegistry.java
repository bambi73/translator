package org.bambi.translation_helper.database;

import java.util.HashMap;
import java.util.Map;

import org.bambi.translation_helper.data.type.ETranslatorProvider;


public class TranslatorDatabaseRegistry {

  private static final Map<ETranslatorProvider, ITranslatorDatabase> provider2TranslatorDatabase = 
      new HashMap<ETranslatorProvider, ITranslatorDatabase>();


  public static ITranslatorDatabase getTranslatorDatabase(ETranslatorProvider translatorType) {
    return provider2TranslatorDatabase.get(translatorType);
  }


  public static void registerTranslatorDatabase(ITranslatorDatabase translatorDatabase) {
    ETranslatorProvider translatorProvider = translatorDatabase.getTranslatorProvider();

    if(provider2TranslatorDatabase.containsKey(translatorProvider)) {
      throw new IllegalStateException(String.format("TranslatorDatabase for provider %s already registered", translatorProvider));
    }

    provider2TranslatorDatabase.put(translatorProvider, translatorDatabase);
  }

}
