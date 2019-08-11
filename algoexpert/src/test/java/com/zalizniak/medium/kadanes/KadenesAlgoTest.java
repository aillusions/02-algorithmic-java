package com.zalizniak.medium.kadanes;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class KadenesAlgoTest {

    private KadenesAlgo calc;

    public KadenesAlgoTest(KadenesAlgo calc) {
        this.calc = calc;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new MyKadenesAlgo()}
        });
    }

    @Test
    public void test() {
        //Assert.assertEquals(0, calc.maxSum(new Integer[]{}));
        Assert.assertEquals(0, calc.maxSum(new Integer[]{-1, -5, -1, -10}));
        Assert.assertEquals(15, calc.maxSum(new Integer[]{1, 5, -1, 0, 10}));
        Assert.assertEquals(0, calc.maxSum(new Integer[]{0, -1, -5, 0, -4}));
        Assert.assertEquals(7, calc.maxSum(new Integer[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }
}