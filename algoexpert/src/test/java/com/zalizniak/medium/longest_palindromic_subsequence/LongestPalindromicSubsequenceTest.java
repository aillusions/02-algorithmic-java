package com.zalizniak.medium.longest_palindromic_subsequence;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubsequenceTest {

    private LongestPalindromicSubsequence gen = new LongestPalindromicSubsequence();

    @Test
    public void test() {
        Assert.assertEquals(0, gen.longestPalindromeSubseq(""));
        Assert.assertEquals(1, gen.longestPalindromeSubseq("ab"));
        Assert.assertEquals(4, gen.longestPalindromeSubseq("abba"));
        Assert.assertEquals(4, gen.longestPalindromeSubseq("12abba34"));
    }
}
