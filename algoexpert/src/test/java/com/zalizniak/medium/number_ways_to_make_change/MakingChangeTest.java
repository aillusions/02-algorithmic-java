package com.zalizniak.medium.number_ways_to_make_change;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@RunWith(Parameterized.class)
public class MakingChangeTest {

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
        Assert.assertEquals(1, maker.numberOfWays(1, new HashSet<>(Arrays.asList(1, 2, 3))));
    }
}
