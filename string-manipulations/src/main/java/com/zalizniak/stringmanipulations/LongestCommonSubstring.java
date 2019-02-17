package com.zalizniak.stringmanipulations;

import org.apache.commons.text.similarity.LongestCommonSubsequence;

public class LongestCommonSubstring {

    public static int longestSubstr(String first, String second) {
        int maxLen = 0;
        int fl = first.length();
        int sl = second.length();
        int[][] table = new int[fl + 1][sl + 1];

        for (int i = 1; i <= fl; i++) {
            for (int j = 1; j <= sl; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    if (table[i][j] > maxLen) {
                        maxLen = table[i][j];
                    }
                }
            }
        }
        return maxLen;
    }

    public static String longestCommonSubstring(String first, String second) {
        int Start = 0;
        int Max = 0;
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                int x = 0;
                while (first.charAt(i + x) == second.charAt(j + x)) {
                    x++;
                    if (((i + x) >= first.length()) || ((j + x) >= second.length())) break;
                }
                if (x > Max) {
                    Max = x;
                    Start = i;
                }
            }
        }
        return first.substring(Start, (Start + Max));
    }

    public static String longestCommonSubstringLib(String strA, String strB) {
        return new LongestCommonSubsequence().longestCommonSubsequence(strA, strB).toString();
    }
}
