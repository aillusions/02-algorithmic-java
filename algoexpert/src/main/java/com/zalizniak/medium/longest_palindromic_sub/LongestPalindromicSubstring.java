package com.zalizniak.medium.longest_palindromic_sub;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

    private Map<String, Integer> cache = new HashMap<>();

    public int longestPalindromeSubstr(String s) {

        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s.length() <= 1) {
            return 0;
        }

        int rv;
        if (PalindromeChecker.isPalindrome(s)) {
            System.out.println("Found palindrome with length: " + s.length() + " ( " + s + " )");
            rv = s.length();
        } else {
            rv = Math.max(longestPalindromeSubstr(s.substring(1)), longestPalindromeSubstr(s.substring(0, s.length() - 1)));
        }

        cache.put(s, rv);

        return rv;
    }
}
