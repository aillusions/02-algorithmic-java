package com.zalizniak.medium.longest_palindromic_sub;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence {

    private Map<String, Integer> cache = new HashMap<>();

    public int longestPalindromeSubseq(String s) {

        if (!cache.containsKey(s)) {

            int max;
            if (s.length() <= 1) {
                max = 0;
            } else if (PalindromeChecker.isPalindrome(s)) {
                max = s.length();
            } else {
                max = Integer.MIN_VALUE;
                for (int i = 0; i < s.length(); i++) {
                    String sub = removeChar(s, i);
                    max = Math.max(max, longestPalindromeSubseq(sub));
                }
            }

            cache.put(s, max);
        }

        System.out.println("Checking: " + s + " - " + cache.get(s));
        return cache.get(s);
    }

    public static String removeChar(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }
}
