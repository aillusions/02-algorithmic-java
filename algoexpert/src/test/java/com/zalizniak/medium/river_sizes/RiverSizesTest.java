package com.zalizniak.medium.river_sizes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RiverSizesTest {

    private RiverSizes riverSizes = new RiverSizes();

    @Test
    public void test() {
        Assert.assertEquals(Arrays.asList(1), riverSizes.riverSizes(new int[][]{{1}}));
    }
}
