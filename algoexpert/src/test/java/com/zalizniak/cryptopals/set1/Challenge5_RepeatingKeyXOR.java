package com.zalizniak.cryptopals.set1;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://cryptopals.com/sets/1/challenges/4
 */
public class Challenge5_RepeatingKeyXOR {

    @Test
    public void test1() {
        final String orig = "Burning 'em, if you ain't quick and nimble";
        final String expected = "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272";

        Assert.assertEquals(expected, repeatingKeyXOR(orig));
    }

    @Test
    public void test2() {
        final String orig = "I go crazy when I hear a cymbal";
        final String expected = "a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f";

        Assert.assertEquals(expected, repeatingKeyXOR(orig));
    }

    public static String repeatingKeyXOR(String in) {
        String key = "ICE";

        return in;
    }
}