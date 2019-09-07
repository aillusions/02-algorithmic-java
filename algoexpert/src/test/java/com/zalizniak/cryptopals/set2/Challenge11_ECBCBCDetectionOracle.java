package com.zalizniak.cryptopals.set2;

import com.zalizniak.cryptopals.set1.Challenge7_AESinECB;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

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
        for (int i = 0; i < 10; i++) {
            RandomEncrypt encryption = randomEncrypt(new byte[]{1, 2, 3, 4});
            System.out.println(encryption.cbc);
        }
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
            return new RandomEncrypt(Challenge10_ImplementCBCmode.encryptCBC(iv, textToEncrypt, key), true);
        } else {
            return new RandomEncrypt(Challenge7_AESinECB.encryptECB(textToEncrypt, key), false);
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
        public byte[] rv;
        public boolean cbc;

        public RandomEncrypt(byte[] rv, boolean cbc) {
            this.rv = rv;
            this.cbc = cbc;
        }
    }

}
