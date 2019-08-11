package com.zalizniak.medium.levenshtein_distance;

import java.util.HashMap;
import java.util.Map;

/**
 * 3^n - exponential
 */
public class MyLevenshteinDistance implements LevenshteinDistance {

    private final Map<String, Integer> cache = new HashMap<>();

    @Override
    public int getDistance(String a, String b) {

        String key = a + " - " + b;
        System.out.println(key);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (a.isEmpty()) {
            cache.put(key, b.length());
        } else if (b.isEmpty()) {
            cache.put(key, a.length());
        } else if (a.charAt(0) == b.charAt(0)) {
            cache.put(key, getDistance(a.substring(1), b.substring(1)));
        } else {

            int d1 = getDistance(a.substring(1), b); // removal / insertion
            int d2 = getDistance(a, b.substring(1)); // removal / insertion
            int d3 = getDistance(a.substring(1), b.substring(1)); // substitutions

            cache.put(key, 1 + Math.min(d1, Math.min(d2, d3)));
        }

        return cache.get(key);
    }

}
