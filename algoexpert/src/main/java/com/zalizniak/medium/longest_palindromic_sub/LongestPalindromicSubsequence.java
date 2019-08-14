package com.zalizniak.medium.longest_palindromic_sub;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        int max;
        if (s.length() <= 1) {
            max = 0;
        } else if (isPalindrome(s)) {
            max = s.length();
        } else {
            max = Integer.MIN_VALUE;
            for (int i = 0; i < s.length(); i++) {
                String sub = removeChar(s, i);
                max = Math.max(max, longestPalindromeSubseq(sub));
            }
        }

        return max;
    }

    private boolean isPalindrome(String s) {

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private String removeChar(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }
}
