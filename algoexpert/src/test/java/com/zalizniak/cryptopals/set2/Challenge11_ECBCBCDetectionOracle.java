package com.zalizniak.cryptopals.set2;

import com.zalizniak.cryptopals.set1.Challenge7_AESinECB;
import org.junit.Test;

import java.util.Random;

/**
 * https://cryptopals.com/sets/2/challenges/11
 * An ECB/CBC detection oracle
 */
public class Challenge11_ECBCBCDetectionOracle {


    @Test
    public void test() {

    }

    public static byte[] randomEncrypt(byte[] text) {
        byte[] key = randomKey();

        byte[] rv = Challenge10_ImplementCBCmode.encryptCBC(text, key);

        return rv;
    }

    public static byte[] randomKey() {
        Random rnd = new Random();
        byte[] key = new byte[Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES];
        rnd.nextBytes(key);
        return key;
    }


}
