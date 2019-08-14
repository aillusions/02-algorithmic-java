package com.zalizniak.medium.longest_palindromic_sub;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeCheckerTest {

    @Test
    public void test() {
        Assert.assertTrue(PalindromeChecker.isPalindrome("abcba"));
        Assert.assertTrue(PalindromeChecker.isPalindrome("abba"));
        Assert.assertTrue(PalindromeChecker.isPalindrome("bb"));
        Assert.assertTrue(PalindromeChecker.isPalindrome("bab"));

        Assert.assertFalse(PalindromeChecker.isPalindrome("abc"));
        Assert.assertFalse(PalindromeChecker.isPalindrome("abc"));
        Assert.assertFalse(PalindromeChecker.isPalindrome("123"));
    }
}
