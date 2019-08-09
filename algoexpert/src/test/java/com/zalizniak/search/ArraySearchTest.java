package com.zalizniak.search;

import org.junit.Assert;
import org.junit.Test;

public class ArraySearchTest {


    @Test
    public void testSearch() {
        Assert.assertEquals(0, ArraySearch.findBinary(new int[]{0, 1, 2, 3}, 0, 3, 0));
        System.out.println();

        Assert.assertEquals(1, ArraySearch.findBinary(new int[]{0, 1, 2, 3}, 0, 3, 1));
        System.out.println();

        Assert.assertEquals(-1, ArraySearch.findBinary(new int[]{0, 1, 2, 3}, 0, 3, 100));
        System.out.println();
    }
}
