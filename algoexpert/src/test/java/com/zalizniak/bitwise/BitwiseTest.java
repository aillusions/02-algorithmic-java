package com.zalizniak.bitwise;

import org.junit.Test;

public class BitwiseTest {

    @Test
    public void testBitwiseOprations() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " -> " + (i << 1));
        }
    }
}
