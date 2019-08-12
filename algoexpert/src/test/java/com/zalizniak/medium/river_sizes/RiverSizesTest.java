package com.zalizniak.medium.river_sizes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RiverSizesTest {

    private RiverSizes riverSizes = new RiverSizes();

    @Test
    public void test() {
        Assert.assertEquals(Arrays.asList(1), riverSizes.riverSizes(new int[][]{{1}}));
        Assert.assertEquals(Arrays.asList(1, 2, 2, 2, 5), riverSizes.riverSizes(new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        }));
    }
}
