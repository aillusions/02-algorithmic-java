package com.zalizniak.caesar_cipher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaesarCipherTest {

    @Test
    public void shouldNotChangeIdxForZeroShift() {
        assertEquals(0, CaesarCipher.shiftIdx(0, 0));
        assertEquals(10, CaesarCipher.shiftIdx(10, 0));
    }

    @Test
    public void shouldIncrementPositionByShift() {
        assertEquals(1, CaesarCipher.shiftIdx(0, 1));
        assertEquals(2, CaesarCipher.shiftIdx(0, 2));
        assertEquals(25, CaesarCipher.shiftIdx(0, 25));
    }

    @Test
    public void shouldDecrementPositionByShift() {
        assertEquals(0, CaesarCipher.shiftIdx(2, -2));
    }

    @Test
    public void shouldCirculatePosition() {
        assertEquals(0, CaesarCipher.shiftIdx(25, 1));
        assertEquals(0, CaesarCipher.shiftIdx(0, 26));
    }

    @Test
    public void shouldShiftChar() {
        assertEquals('e', CaesarCipher.shiftChar('a', 4));
        assertEquals('a', CaesarCipher.shiftChar('z', 1));
        assertEquals('z', CaesarCipher.shiftChar('z', 26));
    }

    @Test
    public void shouldEncode() {
        assertEquals("bcd", CaesarCipher.encode("abc", 1));
    }

    @Test
    public void shouldDecode() {
        assertEquals("abc", CaesarCipher.decode("bcd", 1));
    }

    @Test
    public void shouldEncodeLargeText() {
        System.out.println(CaesarCipher.encode("JAVA HUNGRY\n" +
                "Java developers tutorials and coding.\n" +
                "\n" +
                "Search this blog...\n" +
                " \n" +
                "HOME\n" +
                "STRING\n" +
                "COLLECTIONS\n" +
                "INTERVIEW\n" +
                "INTERVIEW TIPS\n" +
                "DATA-STRUCTURES\n" +
                "SCJP\n" +
                " \n" +
                "THREADS\n" +
                " \n" +
                "BEST JAVA BOOKS\n" +
                " \n" +
                "JAVA CODING PROGRAM\n" +
                " \n" +
                "MORE JAVA TOPICS\n" +
                "Caesar Cipher Program In Java With Output\n" +
                "Caesar cipher technique was founded by Julius caesar. Before looking at the caesar cipher program in java with output for encryption and decryption, first, we need to understand the terms plaintext and ciphertext.\n" +
                "\n" +
                "What is plaintext and ciphertext?\n" +
                "\n" +
                "plaintext is the input message given by user. In other words, message that needs to be encrypted.\n" +
                "\n" +
                "ciphertext is the encrypted message. In other words, message after applying the caesar cipher technique.\n" +
                "\n" +
                "What is Caesar cipher?\n" +
                "\n" +
                "Caesar cipher is one of the simplest encryption technique. It is also known as the shift cipher, Caesar's cipher, Caesar shift or Caesar's code. Caesar cipher is a type of substitution cipher.\n" +
                "\n" +
                "By using this cipher technique we can replace each letter in the plaintext with different one a fixed number of places up or down the alphabet.\n" +
                "\n" +
                "For example :\n" +
                "\n" +
                "With right shift of 3:\n" +
                "\n" +
                "plaintext :      ABCDEFGHIJKLMNOPQRSTUVWXYZ\n" +
                "\n" +
                "ciphertext :    DEFGHIJKLMNOPQRSTUVWXYZABC\n" +
                "\n" +
                "\n" +
                "Caesar cipher program in java with output \n" +
                "\n" +
                "\n" +
                "\n" +
                "With left shift of 3:\n" +
                "\n" +
                "plaintext :      ABCDEFGHIJKLMNOPQRSTUVWXYZ\n" +
                "\n" +
                "ciphertext :    XYZABCDEFGHIJKLMNOPQRSTUVW\n" +
                "\n" +
                "\n" +
                "Caesar cipher left shift of 3 \n" +
                "\n" +
                "With right shift of 2:\n" +
                "\n" +
                "plaintext :   Java Hungry Blog\n" +
                "ciphertext : Lcxc Jwpita Dnqi\n" +
                "\n" +
                "As you can see for the above example \"Java Hungry Blog\" each character in plain text is shifted by 2 as J become L , a become c , v become x and so on.\n" +
                "\n" +
                "Note : You can use either left shift or right shift but not both in same text.\n" +
                "\n" +
                "If we want to see Caesar cipher in mathematical way, then formula to get encrypted letter will be :\n" +
                "\n" +
                "e = (x + n) mod 26\n" +
                "\n" +
                "where,\n" +
                "n is the number of positions we need to shift plaintext characters\n" +
                "x is the place value of original letter\n" +
                "e is the place value of encrypted letter\n" +
                "\n" +
                "On the other hand, we will use the below formula to decrypt each letter.\n" +
                "\n" +
                "e = (x - n) mod 26\n" +
                "\n" +
                "Pseudo Code for Caesar Cipher\n" +
                "Input : String plaintext\n" +
                "Input : An integer between 0 and 25 representing the right shift of the character  or, \n" +
                "an integer between -25 and -1 representing the left shift of the characters. \n" +
                "Traverse each character in the plaintext one at a time\n" +
                "Transform the given character depending on encryption or decryption.\n" +
                "print the ciphertext.\n" +
                "\n" +
                "Simple Caesar Cipher Program in Java for Encryption  \n" +
                "\n" +
                "import java.util.*;\n" +
                "public class CaesarCipherProgram {\n" +
                "    public static void main(String args[]) {\n" +
                "        Scanner sc = new Scanner(System.in);\n" +
                "        System.out.println(\" Input the plaintext message : \");\n" +
                "        String plaintext = sc.nextLine();\n" +
                "        System.out.println(\" Enter the value by which \n" +
                "        each character in the plaintext         \n" +
                "        message gets shifted : \");\n" +
                "        int shift = sc.nextInt();\n" +
                "        String ciphertext = \"\";\n" +
                "        char alphabet;\n" +
                "        for(int i=0; i < plaintext.length();i++) \n" +
                "        {\n" +
                "             // Shift one character at a time\n" +
                "            alphabet = plaintext.charAt(i);\n" +
                "            \n" +
                "            // if alphabet lies between a and z \n" +
                "            if(alphabet >= 'a' && alphabet <= 'z') \n" +
                "            {\n" +
                "             // shift alphabet\n" +
                "             alphabet = (char) (alphabet + shift);\n" +
                "             // if shift alphabet greater than 'z'\n" +
                "             if(alphabet > 'z') {\n" +
                "                // reshift to starting position \n" +
                "                alphabet = (char) (alphabet+'a'-'z'-1);\n" +
                "             }\n" +
                "             ciphertext = ciphertext + alphabet;\n" +
                "            }\n" +
                "            \n" +
                "            // if alphabet lies between 'A'and 'Z'\n" +
                "            else if(alphabet >= 'A' && alphabet <= 'Z') {\n" +
                "             // shift alphabet\n" +
                "             alphabet = (char) (alphabet + shift);    \n" +
                "                \n" +
                "             // if shift alphabet greater than 'Z'\n" +
                "             if(alphabet > 'Z') {\n" +
                "                 //reshift to starting position \n" +
                "                 alphabet = (char) (alphabet+'A'-'Z'-1);\n" +
                "             }\n" +
                "             ciphertext = ciphertext + alphabet;\n" +
                "            }\n" +
                "            else {\n" +
                "             ciphertext = ciphertext + alphabet;   \n" +
                "            }\n" +
                "        \n" +
                "    }\n" +
                "    System.out.println(\" ciphertext : \" + ciphertext);\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "Output :\n" +
                "\n" +
                "Input the plaintext message :  Java Hungry Blog\n" +
                "Enter the value by which each character in the plaintext message gets shifted :  2\n" +
                "ciphertext : Lcxc Jwpita Dnqi \n" +
                "\n" +
                "\n" +
                "Simple Caesar Cipher Program in Java for Decryption  \n" +
                "\n" +
                "import java.util.*;\n" +
                "public class CaesarCipherProgram {\n" +
                "        public static void main(String args[]) {\n" +
                "        Scanner sc = new Scanner(System.in);\n" +
                "        System.out.println(\" Input the ciphertext message : \");\n" +
                "        String ciphertext = sc.nextLine();\n" +
                "        System.out.println(\" Enter the shift value : \");\n" +
                "        int shift = sc.nextInt();\n" +
                "        String decryptMessage = \"\";\n" +
                "        for(int i=0; i < ciphertext.length();i++)  \n" +
                "\n" +
                "        {\n" +
                "            // Shift one character at a time\n" +
                "            char alphabet = ciphertext.charAt(i);\n" +
                "            // if alphabet lies between a and z \n" +
                "            if(alphabet >= 'a' && alphabet <= 'z')\n" +
                "            {\n" +
                "                // shift alphabet\n" +
                "                alphabet = (char) (alphabet - shift);\n" +
                "            \n" +
                "                // shift alphabet lesser than 'a'\n" +
                "                if(alphabet < 'a') {\n" +
                "                    //reshift to starting position \n" +
                "                    alphabet = (char) (alphabet-'a'+'z'+1);\n" +
                "                }\n" +
                "                decryptMessage = decryptMessage + alphabet;\n" +
                "            }    \n" +
                "                // if alphabet lies between A and Z\n" +
                "            else if(alphabet >= 'A' && alphabet <= 'Z')\n" +
                "            {\n" +
                "             // shift alphabet\n" +
                "                alphabet = (char) (alphabet - shift);\n" +
                "                \n" +
                "                //shift alphabet lesser than 'A'\n" +
                "                if (alphabet < 'A') {\n" +
                "                    // reshift to starting position \n" +
                "                    alphabet = (char) (alphabet-'A'+'Z'+1);\n" +
                "                }\n" +
                "                decryptMessage = decryptMessage + alphabet;            \n" +
                "            }\n" +
                "            else \n" +
                "            {\n" +
                "             decryptMessage = decryptMessage + alphabet;            \n" +
                "            } \n" +
                "        }\n" +
                "        System.out.println(\" decrypt message : \" + decryptMessage);\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "Output :\n" +
                "\n" +
                "Input the ciphertext message : Lcxc Jwpita Dnqi \n" +
                "Enter the shift value : 2\n" +
                "decrypt message : Java Hungry Blog \n" +
                "\n" +
                "That's all for the post caesar cipher program in java with output. If you have any questions then please mention in the comments below.\n" +
                "  \n" +
                "Image Credits : Cepheus [Public domain], from Wikimedia Commons\n" +
                "Matt_Crypto [Public domain], via Wikimedia Commons\n" +
                "About The Author \n" +
                "Subham Mittal has worked in Oracle for 3 years . \n" +
                "For more java articles ,Click here to Subscribe JavaHungry\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "WHATS HOT\n" +
                "\n" +
                "Difference between Arraylist and Vector : Core Java Interview Collection Question\n" +
                "\n" +
                "\n" +
                "Best Books for Learning Java\n" +
                "\n" +
                "\n" +
                "Amazon Interview Question : First Non repeated character in String\n" +
                "\n" +
                "\n" +
                "Count total number of times each alphabet appears in the string java program code with example\n" +
                "\n" +
                "\n" +
                "Java 8 new features : Lambda expressions , optional class , Defender methods with examples\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Subscribe for Our Newsletter \n" +
                "\n" +
                "\n" +
                "\n" +
                "POPULAR POSTS\n" +
                "\n" +
                "Java Interview Questions\n" +
                "\n" +
                "Top 50 Java Collections Interview Questions and Answers\n" +
                "\n" +
                "Web Services Interview Questions\n" +
                "\n" +
                "Java Multithreading Interview Questions and Answers\n" +
                "\n" +
                "Java Interview Programs\n" +
                "\n" +
                "Return to Top ↑Java Hungry Copyright © 2019 · All Rights Reserved. Designed by studiopress", 10));
    }

}
