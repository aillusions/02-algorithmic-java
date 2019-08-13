package com.zalizniak.medium.balanced_brackets;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBracketsTest {

    @Test
    public void test() {
        Assert.assertTrue(BalancedBrackets.isBalanced("[]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[[[]]]"));

        Assert.assertFalse(BalancedBrackets.isBalanced("["));
        Assert.assertFalse(BalancedBrackets.isBalanced("[]]"));
        Assert.assertFalse(BalancedBrackets.isBalanced("]]"));
        Assert.assertFalse(BalancedBrackets.isBalanced("]][[]]"));
    }
}
