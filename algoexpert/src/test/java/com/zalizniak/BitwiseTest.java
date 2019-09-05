package com.zalizniak;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BitwiseTest {

    // there are 26 letters in English: to represent all letters enough 5 bits (2 ^ 5 == 32)

    @Test
    public void testBitwiseOperations() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " -> " + (i << 1));
        }
    }

    @Test
    public void binaryString() throws UnsupportedEncodingException {
        System.out.println("0" + " -> " + Integer.toBinaryString(0));
        System.out.println("1" + " -> " + Integer.toBinaryString(1));
        System.out.println("1000" + " -> " + Integer.toBinaryString(1000));

        System.out.println("a" + " -> " + convertToBinary("a", "UTF-32"));

        System.out.println("a" + " -> " + convertToBinary("a", "UTF-8"));
        System.out.println("aa" + " -> " + convertToBinary("aa", "UTF-8"));
        System.out.println("aaa" + " -> " + convertToBinary("aaa", "UTF-8"));
        System.out.println("aaa" + " -> " + convertToBinary("語", "UTF-8"));

        Assert.assertEquals("10101011", convertToBinary("T", "UTF-8"));
    }

    public String convertToBinary(String input, String encoding) throws UnsupportedEncodingException {

        byte[] encoded_input = Charset.forName(encoding)
                .encode(input)
                .array();

        return IntStream.range(0, encoded_input.length)
                .map(i -> encoded_input[i])
                .mapToObj(e -> Integer.toBinaryString(e ^ 255))
                .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
                .collect(Collectors.joining(" "));
    }
}
