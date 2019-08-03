package com.zalizniak;

import junit.framework.TestCase;
import org.junit.Test;

public class FindClosestNumberTest {

    @Test
    public void shouldFindClosest() {
        TestCase.assertEquals(82, FindClosestNumber.getClosest(80, new int[]{2, 42, 82, 122, 162, 202, 242, 282, 322, 362}));
    }
}
