package com.zalizniak.search;

import org.junit.Assert;
import org.junit.Test;

public class ArraySearchTest {


    @Test
    public void testSearch() {
        Assert.assertEquals(0, ArraySearch.findBinary(new int[]{0, 1, 2, 3}, 0, 4, 0));
        //Assert.assertEquals(1, ArraySearch.findBinary(new int[]{0, 1, 2, 3}, 0, 4, 1));
        //Assert.assertEquals(-1, ArraySearch.findBinary(new int[]{0, 1, 2, 3}, 0, 4, 100));
    }
}
