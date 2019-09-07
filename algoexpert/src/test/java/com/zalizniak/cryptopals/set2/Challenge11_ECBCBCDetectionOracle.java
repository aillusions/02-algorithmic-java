package com.zalizniak.cryptopals.set2;

import com.zalizniak.cryptopals.set1.Challenge7_AESinECB;
import org.junit.Test;

import java.util.Random;

/**
 * https://cryptopals.com/sets/2/challenges/11
 * An ECB/CBC detection oracle
 */
public class Challenge11_ECBCBCDetectionOracle {

    private static final Random RANDOM = new Random();

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(randomEncrypt(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9}).cbc);
        }
    }

    public static RandomEncrypt randomEncrypt(byte[] text) {
        byte[] key = randomByteArray(Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES);

        if (randomBoolean()) {
            byte[] iv = randomByteArray(Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES);
            return new RandomEncrypt(Challenge10_ImplementCBCmode.encryptCBC(iv, text, key), true);
        } else {
            return new RandomEncrypt(Challenge7_AESinECB.encryptECB(text, key), false);
        }
    }

    public static boolean randomBoolean() {
        return RANDOM.nextBoolean();
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
