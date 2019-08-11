package com.zalizniak.medium.coin_change;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class MakingChangeTest {

    private static final List<Integer> DENOMINATIONS_NATURAL = Arrays.asList(20, 10, 5, 1);
    //private static final List<Integer> DENOMINATIONS_MATH = Arrays.asList(3, 2, 1);

    private MakingChange maker;

    public MakingChangeTest(MakingChange maker) {
        this.maker = maker;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new MySolution()}
        });
    }

    @Test
    public void shouldFindSum() {
        Assert.assertEquals(1, maker.numberOfWays(1, DENOMINATIONS_NATURAL)); // {1}
        Assert.assertEquals(1, maker.numberOfWays(4, DENOMINATIONS_NATURAL)); // {1,1,1,1}
        Assert.assertEquals(2, maker.numberOfWays(5, DENOMINATIONS_NATURAL)); // {5}, {1,1,1,1,1}
        Assert.assertEquals(2, maker.numberOfWays(6, DENOMINATIONS_NATURAL)); // {5,1} {1,1,1,1,1,1}
        Assert.assertEquals(3, maker.numberOfWays(10, DENOMINATIONS_NATURAL)); // {5,5} {1,1,1,1,1,1,1,1,1,1} {5,1,1,1,1,1)
    }

    //@Test
    //public void shouldFindSum0() {
    //    Assert.assertEquals(4, maker.numberOfWays(4, DENOMINATIONS_MATH));
    //}
}
