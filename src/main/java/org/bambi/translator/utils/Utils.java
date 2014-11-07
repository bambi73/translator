package org.bambi.translator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Utils {

  public static <K, V> void addValueToListInMap(Map<K, List<V>> map, K key, V value) {
    getListInMap(map, key).add(value);
  }


  public static <K, V> List<V> getListInMap(Map<K, List<V>> map, K key) {
    List<V> list = map.get(key);

    if(list == null) {
      map.put(key, (list = new ArrayList<V>()));
    }

    return list;
  }

  public static String stripLastCharacter(String string) {
    return stripCharacters(string, 1);
  }
  

  public static String stripCharacters(String string, int count) {
    return string.substring(0, string.length() - count);
  }

}
