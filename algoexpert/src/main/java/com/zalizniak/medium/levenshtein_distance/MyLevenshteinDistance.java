package com.zalizniak.medium.levenshtein_distance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyLevenshteinDistance implements LevenshteinDistance {

    @Override
    public int getDistance(String a, String b) {

        return getDistance(a.chars().mapToObj(i -> (char) i).collect(Collectors.toList()),
                b.chars().mapToObj(i -> (char) i).collect(Collectors.toList()),
                Arrays.asList("i", "d", "s"));
    }

    public int getDistance(List<Character> a, List<Character> b, List<String> operations) {
        //if (a.toString().equals(b.toString())) {
        if (a.isEmpty() && b.isEmpty()) {
            return 0;
        }

        if (a.get(0) == b.get(0)) {
            return getDistance(a.subList(1, a.size()), b.subList(1, b.size()), operations);
        }

        //int minDelta = 0;
        //for (String operation : operations) {
//
        //}
//
        //return getDistance(a, b, operations);
        return 0;
    }


}
