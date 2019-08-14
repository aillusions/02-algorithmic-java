package com.zalizniak.medium.longest_palindromic_sub;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubsequenceTest {

    private LongestPalindromicSubsequence gen = new LongestPalindromicSubsequence();

    @Test
    public void test() {
        // Assert.assertEquals(5, gen.longestPalindromeSubseq("geeksforgeeks")); // EEKEE, EESEE, EEFEE
        // Assert.assertEquals(7, gen.longestPalindromeSubseq("BBABCBCAB")); // BABCBAB, BBBBB, BBCBB
        // Assert.assertEquals(4, gen.longestPalindromeSubseq("bbbab")); // bbbb
        Assert.assertEquals(2, gen.longestPalindromeSubseq("cbbd")); // bb
        // Assert.assertEquals(6, gen.longestPalindromeSubseq("1abba1")); // 1abba1
        // Assert.assertEquals(4, gen.longestPalindromeSubseq("1abba2")); // abba
    }
}
