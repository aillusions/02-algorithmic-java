package com.zalizniak.palindrome;

/**
 * E.g: madam - true
 * E.g: four - false
 */
public class PalindromeChecker {

    public static boolean isPalindrome(String text) {

        if (text.isEmpty()) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length >> 1; i++) {
            if (chars[i] != chars[(chars.length - 1) - i]) {
                return false;
            }
        }

        return true;
    }
}
