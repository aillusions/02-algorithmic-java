package com.zalizniak;

import junit.framework.TestCase;
import org.junit.Assert;

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
public class FibonacciSeriesTest extends TestCase {

    public void test() {
        Assert.assertEquals(0, FibonacciSeries.getNthFib(1));
        Assert.assertEquals(1, FibonacciSeries.getNthFib(2));
        Assert.assertEquals(1, FibonacciSeries.getNthFib(3));
        Assert.assertEquals(2, FibonacciSeries.getNthFib(4));
        Assert.assertEquals(3, FibonacciSeries.getNthFib(5));
        Assert.assertEquals(5, FibonacciSeries.getNthFib(6));
        Assert.assertEquals(8, FibonacciSeries.getNthFib(7));
        Assert.assertEquals(13, FibonacciSeries.getNthFib(8));
    }
}
