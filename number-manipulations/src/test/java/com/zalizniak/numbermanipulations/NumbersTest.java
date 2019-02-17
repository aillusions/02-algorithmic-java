package com.zalizniak.numbermanipulations;

import org.junit.Assert;
import org.junit.Test;

public class NumbersTest {

    @Test
    public void testReverse() {
        Assert.assertEquals(4321, ReverseNumber.reverse(1234));
    }
}
