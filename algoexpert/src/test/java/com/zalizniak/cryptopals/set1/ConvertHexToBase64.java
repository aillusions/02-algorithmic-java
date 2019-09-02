package com.zalizniak.cryptopals.set1;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://cryptopals.com/sets/1/challenges/1
 */
public class ConvertHexToBase64 {

    @Test
    public void test() {
        Assert.assertEquals("SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t",
                hexToBase64("49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"));
    }

    public static String hexToBase64(String in) {
        byte[] rawBytes = in.getBytes();



        return in;
    }
}
