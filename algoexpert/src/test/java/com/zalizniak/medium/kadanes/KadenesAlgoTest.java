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
        Assert.assertEquals(0, calc.maxSum(new Integer[]{}));
    }
}