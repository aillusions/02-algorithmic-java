package com.zalizniak.stringmanipulations;

public class StringReverse {

    public static String reverse(String str) {
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    public static String reverseSb(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static String reverseSb2(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
