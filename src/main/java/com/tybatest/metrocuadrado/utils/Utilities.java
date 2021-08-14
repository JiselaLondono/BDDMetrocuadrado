package com.tybatest.metrocuadrado.utils;

public final class Utilities {

  private static final String ORIGINAL = "ÁáÉéÍíÓóÚúÑñÜü";
  private static final String REPLACEMENT = "AaEeIiOoUuNnUu";

  public static String replaceAccents(String text) {
    if (text == null) {
      return null;
    }
    char[] array = text.toCharArray();
    for (int index = 0; index < array.length; index++) {
      int pos = ORIGINAL.indexOf(array[index]);
      if (pos > -1) {
        array[index] = REPLACEMENT.charAt(pos);
      }
    }
    return new String(array);
  }
}
