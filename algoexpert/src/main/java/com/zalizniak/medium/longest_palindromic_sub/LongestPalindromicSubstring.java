package com.zalizniak.medium.longest_palindromic_sub;

public class LongestPalindromicSubstring {

    public int longestPalindromeSubstr(String s) {

        if (s.length() <= 1) {
            return 0;
        }

        if (PalindromeChecker.isPalindrome(s)) {
            System.out.println("Found palindrome with length: " + s.length() + " ( " + s + " )");
        }

        return 0;
    }
}
