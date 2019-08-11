package com.zalizniak.medium.levenshtein_distance;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LevenshteinDistanceTest {

    private LevenshteinDistance calc;

    public LevenshteinDistanceTest(LevenshteinDistance calc) {
        this.calc = calc;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new MyLevenshteinDistance()},
                {new IterativeLevenshteinDistance()}
        });
    }

    @Test
    public void calcForLongSentence() {
        Assert.assertEquals(5, calc.getDistance("ABCDE", "FGHI"));
    }

    @Test
    public void shouldCalculateDistance() {
        Assert.assertEquals(0, calc.getDistance("ALEX", "ALEX"));
        Assert.assertEquals(3, calc.getDistance("FLOMAX", "VOLMAX"));
        Assert.assertEquals(2, calc.getDistance("GILY", "GEELY"));
        Assert.assertEquals(3, calc.getDistance("HONDA", "HYUNDAI"));
        Assert.assertEquals(1, calc.getDistance("shot", "spot"));


        // https://commons.apache.org/sandbox/commons-text/jacoco/org.apache.commons.text.similarity/LevenshteinDistance.java.html
        Assert.assertEquals(0, calc.getDistance("", ""));
        Assert.assertEquals(1, calc.getDistance("", "a"));
        Assert.assertEquals(7, calc.getDistance("aaapppp", ""));
        Assert.assertEquals(1, calc.getDistance("frog", "fog"));
        Assert.assertEquals(3, calc.getDistance("fly", "ant"));
        Assert.assertEquals(7, calc.getDistance("elephant", "hippo"));
        Assert.assertEquals(7, calc.getDistance("hippo", "elephant"));
        Assert.assertEquals(8, calc.getDistance("hippo", "zzzzzzzz"));
        Assert.assertEquals(1, calc.getDistance("hello", "hallo"));
    }
}