package org.bambi.translator.database;

import java.util.HashMap;
import java.util.Map;

import org.bambi.translator.data.type.ETranslationProvider;


public class TranslatorDatabaseRegistry {

  private static final Map<ETranslationProvider, ITranslatorDatabase> provider2TranslatorDatabase = 
      new HashMap<ETranslationProvider, ITranslatorDatabase>();


  public static ITranslatorDatabase getTranslatorDatabase(ETranslationProvider translatorProvider) {
    return provider2TranslatorDatabase.get(translatorProvider);
  }


  public static void registerTranslatorDatabase(ITranslatorDatabase translatorDatabase) {
    ETranslationProvider translatorProvider = translatorDatabase.getTranslationProvider();

    if(provider2TranslatorDatabase.containsKey(translatorProvider)) {
      throw new IllegalStateException(String.format("TranslatorDatabase for provider %s already registered", translatorProvider));
    }

    provider2TranslatorDatabase.put(translatorProvider, translatorDatabase);
  }

}
