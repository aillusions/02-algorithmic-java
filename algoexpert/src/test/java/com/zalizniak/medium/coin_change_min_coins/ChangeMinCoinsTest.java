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
    }

}
