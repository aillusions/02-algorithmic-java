package com.zalizniak.medium.coin_change_min_coins;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ChangeMinCoinsTest {

    private static final List<Integer> DENOMINATIONS = Arrays.asList(20, 10, 5, 1);

    private ChangeMinCoins maker;

    public ChangeMinCoinsTest(ChangeMinCoins maker) {
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
        Assert.assertEquals(1, maker.minCoins(1, DENOMINATIONS));
        Assert.assertEquals(1, maker.minCoins(5, DENOMINATIONS));
        Assert.assertEquals(1, maker.minCoins(10, DENOMINATIONS));
        Assert.assertEquals(1, maker.minCoins(20, DENOMINATIONS));
        Assert.assertEquals(2, maker.minCoins(21, DENOMINATIONS));
        Assert.assertEquals(3, maker.minCoins(50, DENOMINATIONS));
    }

    @Test
    public void shouldFindSum0() {
        Assert.assertEquals(2, maker.minCoins(30, Arrays.asList(25, 10, 5)));
        Assert.assertEquals(2, maker.minCoins(11, Arrays.asList(9, 6, 5, 1)));
    }

}
