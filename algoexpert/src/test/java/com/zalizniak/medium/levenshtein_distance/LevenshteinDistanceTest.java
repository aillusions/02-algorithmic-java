package com.zalizniak.medium.levenshtein_distance;

import org.junit.Assert;
import org.junit.Test;

public class LevenshteinDistanceTest {

    private LevenshteinDistance calc = new MyLevenshteinDistance();

    @Test
    public void shouldCalculateDistance() {
        Assert.assertEquals(3, calc.getDistance("FLOMAX", "VOLMAX"));
        Assert.assertEquals(2, calc.getDistance("GILY", "GEELY"));
        Assert.assertEquals(3, calc.getDistance("HONDA", "HYUNDAI"));
    }
}
