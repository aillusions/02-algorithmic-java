package com.zalizniak.stringmanipulations;

import org.junit.Assert;
import org.junit.Test;

public class StringReverseTest {

    @Test
    public void testReverse() {
        Assert.assertEquals("cba", StringReverse.reverse("abc"));
    }

    @Test
    public void testReverseSb() {
        Assert.assertEquals("cba", StringReverse.reverseSb("abc"));
    }

    @Test
    public void testReverseSb2() {
        Assert.assertEquals("cba", StringReverse.reverseSb2("abc"));
    }
}
