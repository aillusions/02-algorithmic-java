package com.zalizniak.numbermanipulations;

import org.junit.Assert;
import org.junit.Test;

public class NumbersTest {

    @Test
    public void testReverse() {
        Assert.assertEquals(4321, ReverseNumber.reverse(1234));
    }

    @Test
    public void testPalindrome() {
        Assert.assertTrue(ReverseNumber.palindrome(12344321));
        Assert.assertFalse(ReverseNumber.palindrome(12345678));
    }
}
