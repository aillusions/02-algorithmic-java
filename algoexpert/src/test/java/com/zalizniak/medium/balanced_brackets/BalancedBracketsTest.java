package com.zalizniak.medium.balanced_brackets;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBracketsTest {

    @Test
    public void testClear() {
        Assert.assertTrue(BalancedBrackets.isBalanced("[]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[][][]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[[[]]]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[[][][]]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[[][[][]][]]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[[]]"));

        Assert.assertFalse(BalancedBrackets.isBalanced("["));
        Assert.assertFalse(BalancedBrackets.isBalanced("][]["));
        Assert.assertFalse(BalancedBrackets.isBalanced("]["));
        Assert.assertFalse(BalancedBrackets.isBalanced("[]]"));
        Assert.assertFalse(BalancedBrackets.isBalanced("]]"));
        Assert.assertFalse(BalancedBrackets.isBalanced("[[[]]"));
        Assert.assertFalse(BalancedBrackets.isBalanced("]][[]]"));
    }

    @Test
    public void testNoisy() {
        Assert.assertTrue(BalancedBrackets.isBalanced("[1]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[a][b][c]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[[[try]]]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[[n][i][j]]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("n[[p][[h][f]]a[]]"));
        Assert.assertTrue(BalancedBrackets.isBalanced("[[]]"));

        Assert.assertFalse(BalancedBrackets.isBalanced("r["));
        Assert.assertFalse(BalancedBrackets.isBalanced("r][]["));
        Assert.assertFalse(BalancedBrackets.isBalanced("r]["));
        Assert.assertFalse(BalancedBrackets.isBalanced("r[]]"));
        Assert.assertFalse(BalancedBrackets.isBalanced("r]]"));
        Assert.assertFalse(BalancedBrackets.isBalanced("r[[[]]"));
        Assert.assertFalse(BalancedBrackets.isBalanced("r]][[]]"));
    }
}
