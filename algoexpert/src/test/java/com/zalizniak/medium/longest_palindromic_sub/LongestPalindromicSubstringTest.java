package com.zalizniak.medium.longest_palindromic_sub;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring gen = new LongestPalindromicSubstring();

    @Test
    public void test() {
        Assert.assertEquals(3, gen.longestPalindromeSubstr("RTR")); // RTR
        Assert.assertEquals(3, gen.longestPalindromeSubstr("abxyx")); // xyx
        Assert.assertEquals(3, gen.longestPalindromeSubstr("BBABCBCAB")); // BAB, CBC
        Assert.assertEquals(3, gen.longestPalindromeSubstr("bbbab")); // bbb
        Assert.assertEquals(2, gen.longestPalindromeSubstr("cbbd")); // bb
        Assert.assertEquals(6, gen.longestPalindromeSubstr("viv1abba1")); // 1abba1
        Assert.assertEquals(4, gen.longestPalindromeSubstr("1abba2TiT")); // abba
        Assert.assertEquals(10, gen.longestPalindromeSubstr("forgeeksskeegfor")); // geeksskeeg
    }
}
