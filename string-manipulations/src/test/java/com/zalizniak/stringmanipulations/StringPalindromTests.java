package com.zalizniak.stringmanipulations;

import org.junit.Assert;
import org.junit.Test;

public class StringPalindromTests {

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(StringPalindrome.isPalindrome("aba"));
        Assert.assertFalse(StringPalindrome.isPalindrome("abc"));
    }

    @Test
    public void testIsPalindromeSb() {
        Assert.assertTrue(StringPalindrome.isPalindromeSb("aba"));
        Assert.assertFalse(StringPalindrome.isPalindromeSb("abc"));
    }

    @Test
    public void testIsPalindromeCh() {
        Assert.assertTrue(StringPalindrome.isPalindromeCh("aba"));
        Assert.assertFalse(StringPalindrome.isPalindromeCh("abc"));
    }
}
