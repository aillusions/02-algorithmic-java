package com.zalizniak.easy;

import junit.framework.TestCase;
import org.junit.Assert;

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
public class FibonacciSeriesTest extends TestCase {

    public void test() {
        Assert.assertEquals(0, FibonacciSeries.getNthFibRec(1));
        Assert.assertEquals(1, FibonacciSeries.getNthFibRec(2));
        Assert.assertEquals(1, FibonacciSeries.getNthFibRec(3));
        Assert.assertEquals(2, FibonacciSeries.getNthFibRec(4));
        Assert.assertEquals(3, FibonacciSeries.getNthFibRec(5));
        Assert.assertEquals(5, FibonacciSeries.getNthFibRec(6));
        Assert.assertEquals(8, FibonacciSeries.getNthFibRec(7));
        Assert.assertEquals(13, FibonacciSeries.getNthFibRec(8));

        Assert.assertEquals(63245986, FibonacciSeries.getNthFibRec(40));
    }

    public void test2() {
        Assert.assertEquals(0, FibonacciSeries.getNthFibIt(1));
        Assert.assertEquals(1, FibonacciSeries.getNthFibIt(2));
        Assert.assertEquals(1, FibonacciSeries.getNthFibIt(3));
        Assert.assertEquals(2, FibonacciSeries.getNthFibIt(4));
        Assert.assertEquals(3, FibonacciSeries.getNthFibIt(5));
        Assert.assertEquals(5, FibonacciSeries.getNthFibIt(6));
        Assert.assertEquals(8, FibonacciSeries.getNthFibIt(7));
        Assert.assertEquals(13, FibonacciSeries.getNthFibIt(8));

        Assert.assertEquals(63245986, FibonacciSeries.getNthFibIt(40));

        Assert.assertEquals(1836311903, FibonacciSeries.getNthFibIt(47));
    }
}
