package com.zalizniak.easy.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeCheckerTest {

    @Test
    public void shouldCheckPalindrome() {
        assertTrue(PalindromeChecker.isPalindrome("madam"));
        assertTrue(PalindromeChecker.isPalindrome("maddam"));
        assertTrue(PalindromeChecker.isPalindrome("abcdedcba"));

        assertFalse(PalindromeChecker.isPalindrome("nope"));
    }
}
