package com.zalizniak.medium.coin_change_num_ways;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ChangeNumWaysTest {

    private static final List<Integer> DENOMINATIONS = Arrays.asList(20, 10, 5, 1);

    private ChangeNumWays maker;

    public ChangeNumWaysTest(ChangeNumWays maker) {
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
        Assert.assertEquals(1, maker.numberOfWays(1, DENOMINATIONS)); // {1}
        Assert.assertEquals(1, maker.numberOfWays(4, DENOMINATIONS)); // {1,1,1,1}
        Assert.assertEquals(2, maker.numberOfWays(5, DENOMINATIONS)); // {5}, {1,1,1,1,1}
        Assert.assertEquals(2, maker.numberOfWays(6, DENOMINATIONS)); // {5,1} {1,1,1,1,1,1}
        Assert.assertEquals(4, maker.numberOfWays(10, DENOMINATIONS)); // {10}, {5,5} {1,1,1,1,1,1,1,1,1,1} {5,1,1,1,1,1)
    }

    @Test
    public void largeAmount() {
        Assert.assertEquals(1771, maker.numberOfWays(200, DENOMINATIONS));
    }
}
