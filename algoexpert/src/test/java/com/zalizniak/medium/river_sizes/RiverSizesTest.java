package com.zalizniak.medium.river_sizes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RiverSizesTest {

    @Test
    public void test() {
        //Assert.assertEquals(Arrays.asList(1), new RiverSizes(new int[][]{{1}}).riverSizes());
        Assert.assertEquals(Arrays.asList(1, 2, 2, 2, 5), new RiverSizes(new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        }).riverSizes());
    }
}
