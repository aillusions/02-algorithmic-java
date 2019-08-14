package com.zalizniak.medium.longest_palindromic_sub;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence {

    private Map<String, Integer> cache = new HashMap<>();

    public int longestPalindromeSubseq(String s) {

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        int rv;
        System.out.println("Checking: " + s);
        if (s.length() <= 1) {
            rv = 0;
        } else if (PalindromeChecker.isPalindrome(s)) {
            rv = s.length();
        } else {
            rv = Integer.MIN_VALUE;
            for (int i = 0; i < s.length(); i++) {
                String sub = removeChar(s, i);
                rv = Math.max(rv, longestPalindromeSubseq(sub));
            }
        }

        cache.put(s, rv);

        return rv;
    }

    public static String removeChar(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }
}
