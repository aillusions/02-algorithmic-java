package com.zalizniak.stringmanipulations;

public class StringPalindrome {

    public static boolean isPalindromeSb(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static boolean isPalindromeCh(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String str) {

        char[] word = str.toCharArray();

        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
