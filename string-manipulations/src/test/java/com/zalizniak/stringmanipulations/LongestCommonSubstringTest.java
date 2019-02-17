package com.zalizniak.stringmanipulations;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubstringTest {

    @Test
    public void testLongestSubstr() {
        Assert.assertEquals(0, LongestCommonSubstring.longestSubstr("", ""));
        Assert.assertEquals(3, LongestCommonSubstring.longestSubstr("1abcde", "abc"));
    }

    @Test
    public void testLongestCommonSubstring() {
        Assert.assertEquals("", LongestCommonSubstring.longestCommonSubstring("", ""));
        Assert.assertEquals("abc", LongestCommonSubstring.longestCommonSubstring("1abcde", "abc"));
    }

    @Test
    public void testLongestCommonSubstringLib() {
        Assert.assertEquals("", LongestCommonSubstring.longestCommonSubstringLib("", ""));
        Assert.assertEquals("abc", LongestCommonSubstring.longestCommonSubstringLib("1abcde", "abc"));
    }
}
