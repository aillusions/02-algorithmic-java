package com.zalizniak.cryptopals.set2;

import com.zalizniak.ByteArraysTest;
import com.zalizniak.cryptopals.set1.Challenge7_AESinECB;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * https://cryptopals.com/sets/2/challenges/11
 * An ECB/CBC detection oracle
 */
public class Challenge11_ECBCBCDetectionOracle {

    private static final Random RANDOM = new Random();

    @Test
    public void testRandomByteArray() {
        for (int i = 0; i < 1000; i++) {
            byte[] randomArray = randomByteArray(5, 10);
            Assert.assertTrue(randomArray.length >= 5 && randomArray.length <= 10);
        }
    }

    @Test
    public void test() {
        byte[] plainText = new byte[5 * Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES];
        for (int i = 0; i < plainText.length; i++) {
            plainText[i] = 'a';
        }

        for (int i = 0; i < 100; i++) {
            RandomEncrypt encryption = randomEncrypt(plainText);
            System.out.println(encryption.ecb);
            Assert.assertEquals(encryption.ecb, guessECB(encryption.cypherText));
        }
    }

    public static boolean guessECB(byte[] cypherText) {
        byte[][] blocks = ByteArraysTest.splitOnBlocks(cypherText, Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES);
        Set<String> blocksSet = new HashSet<>();

        for (int i = 0; i < blocks.length; i++) {
            byte[] block = blocks[i];
            String blockStr = new String(block, StandardCharsets.UTF_8);
            blocksSet.add(blockStr);
        }

        return blocksSet.size() < blocks.length;
    }

    public static RandomEncrypt randomEncrypt(byte[] text) {
        byte[] key = randomByteArray(Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES);
        byte[] randomPrefix = randomByteArray(5, 10);
        byte[] randomSuffix = randomByteArray(5, 10);

        byte[] textToEncrypt = new byte[randomPrefix.length + text.length + randomSuffix.length];
        System.arraycopy(randomPrefix, 0, textToEncrypt, 0, randomPrefix.length);
        System.arraycopy(text, 0, textToEncrypt, randomPrefix.length, text.length);
        System.arraycopy(randomSuffix, 0, textToEncrypt, randomPrefix.length + text.length, randomSuffix.length);

        if (randomBoolean()) {
            byte[] iv = randomByteArray(Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES);
            return new RandomEncrypt(Challenge10_ImplementCBCmode.encryptCBC(iv, textToEncrypt, key), false);
        } else {
            return new RandomEncrypt(Challenge7_AESinECB.encryptECB(textToEncrypt, key), true);
        }
    }

    public static boolean randomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static byte[] randomByteArray(int sizeMin, int sizeMax) {
        int size = RANDOM.nextInt((sizeMax - sizeMin) + 1) + sizeMin;
        return randomByteArray(size);
    }

    public static byte[] randomByteArray(int size) {
        byte[] key = new byte[size];
        RANDOM.nextBytes(key);
        return key;
    }

    public static class RandomEncrypt {
        public byte[] cypherText;
        public boolean ecb;

        public RandomEncrypt(byte[] cypherText, boolean ecb) {
            this.cypherText = cypherText;
            this.ecb = ecb;
        }
    }

}
