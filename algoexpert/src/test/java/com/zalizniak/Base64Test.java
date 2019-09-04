package com.zalizniak;

import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

public class Base64Test {

    @Test
    public void test() {
        System.out.println("" + " --> " + encodeString(""));
        System.out.println(" " + " --> " + encodeString(" "));
        System.out.println("a" + " --> " + encodeString("a"));
        System.out.println("aa" + " --> " + encodeString("aa"));
        System.out.println("aaa" + " --> " + encodeString("aaa"));
        System.out.println("aaaa" + " --> " + encodeString("aaaa"));
        System.out.println("aaaaa" + " --> " + encodeString("aaaaa"));
        System.out.println("0" + " --> " + encodeString("0"));
        System.out.println("1" + " --> " + encodeString("1"));

        Assert.assertEquals("123-abc-DEF", decodeString(encodeString("123-abc-DEF")));
    }

    public static String encodeString(byte[] in) {
        return Base64.getEncoder().encodeToString(in);
    }

    public static String encodeString(String in) {
        return encodeString(in.getBytes());
    }

    public static String decodeString(String in) {
        return new String(Base64.getDecoder().decode(in));
    }
}
