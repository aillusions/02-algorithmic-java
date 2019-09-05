package com.zalizniak;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ByteArraysTest {


    // 2 bytes, 65,536 characters
    @Test
    public void charToBytes() {
        char origChar = 'a';
        byte[] bytes = ByteBuffer.allocate(2).putChar(origChar).array();
        byte[] reverseBytes = ByteBuffer.allocate(2).putChar(Character.reverseBytes(origChar)).array();
        ByteBuffer reverseBuffer = ByteBuffer.wrap(reverseBytes);

        System.out.println(((int) origChar) + " == " + Arrays.toString(bytes) + "  <->  " + Arrays.toString(reverseBytes) + " == " + ((int) reverseBuffer.getChar()));

        System.out.println((int) origChar + " -> " + Arrays.toString(integerToBytes(origChar)));
        System.out.println('慡' + " -> " + Arrays.toString(integerToBytes('慡')));

    }

    @Test
    public void intToBytes() {
        System.out.println(Integer.MAX_VALUE + " -> " + Arrays.toString(intToBytes(Integer.MAX_VALUE)));
        System.out.println(800 + " -> " + Arrays.toString(intToBytes(800)));
        System.out.println(1 + " -> " + Arrays.toString(intToBytes(1)));
        System.out.println(0 + " -> " + Arrays.toString(intToBytes(0)));
        System.out.println(Integer.MIN_VALUE + " -> " + Arrays.toString(intToBytes(Integer.MIN_VALUE)));

        System.out.println(10 + " -> " + Arrays.toString(integerToBytes(10)));
        System.out.println(10 + " -> " + Arrays.toString(intToByteArrayBaos(10)));
    }

    @Test
    public void temp() {
        char character = 'ℋ'; // 2 bytes (16 bits)
        byte[] charBytes = ByteBuffer.allocate(2).putChar(character).array();

        System.out.println(((int) character) +
                " -> " + Arrays.toString(charBytes) +
                " ->  " + new String(charBytes, StandardCharsets.UTF_16) +
                " -> " + Arrays.toString(new String(charBytes, StandardCharsets.UTF_16).getBytes(StandardCharsets.UTF_16)));
    }

    @Test
    public void stringToBytes() {
        System.out.println("" + " -> " + Arrays.toString("".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" " + " -> " + Arrays.toString(" ".getBytes(StandardCharsets.UTF_8)));
        System.out.println("1" + " -> " + Arrays.toString("1".getBytes(StandardCharsets.UTF_8)));

        System.out.println("a" + " -> " + Arrays.toString("a".getBytes(StandardCharsets.UTF_8)));
        System.out.println("aa" + " -> " + Arrays.toString("aa".getBytes(StandardCharsets.UTF_8)));
        System.out.println("aaa" + " -> " + Arrays.toString("aaa".getBytes(StandardCharsets.UTF_8)));
        System.out.println("aaa" + 'я' + " -> " + Arrays.toString(("aaa" + 'я').getBytes(StandardCharsets.UTF_8)));
        System.out.println("aaa" + ((char) 126) + " -> " + Arrays.toString(("aaa" + ((char) 126)).getBytes(StandardCharsets.UTF_8)));

        {
            byte[] bytes = ("aa").getBytes(StandardCharsets.UTF_8);
            System.out.println(Arrays.toString(bytes) + " -> " + new String(bytes, StandardCharsets.UTF_8));
            System.out.println(ByteBuffer.wrap(new byte[]{97, 97}).getChar());
        }

        {
            byte[] bytes = ("慡").getBytes(StandardCharsets.UTF_16);
            System.out.println(Arrays.toString(bytes) + " -> " + new String(bytes, StandardCharsets.UTF_16));
            System.out.println(ByteBuffer.wrap(new byte[]{97, 97}).getChar());
        }
    }

    @Test
    public void stringConversion() {
        byte[] bytes = new byte[2];
        for (byte i = 0; i < 127; i++) {
            for (byte j = 0; j < 127; j++) {
                bytes[0] = i;
                bytes[1] = j;
                System.out.print(Arrays.toString(bytes) + " -> " + ByteBuffer.wrap(bytes).getChar() + " ");
            }
            System.out.println();
        }
    }

    public static byte[] intToBytes(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public static byte[] integerToBytes(int value) {
        return BigInteger.valueOf(value).toByteArray();
    }

    public static byte[] intToByteArrayBaos(int i) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeInt(i);
            dos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] intToByteArray(int value) {
        return new byte[]{
                (byte) (value >>> 24),
                (byte) (value >>> 16),
                (byte) (value >>> 8),
                (byte) value
        };
    }

}
