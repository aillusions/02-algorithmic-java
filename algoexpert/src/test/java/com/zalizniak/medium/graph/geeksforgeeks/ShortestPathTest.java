package com.zalizniak.medium.graph.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

public class ShortestPathTest {

    // directed unweighted graph of 6 nodes, see
    private ShortestPath finder = new ShortestPath(new int[][]{
            /*0*/ {1, 2, 5},
            /*1*/ {4},
            /*2*/ {},
            /*3*/ {1, 5},
            /*4*/ {0, 3},
            /*5*/ {2}
    });

    @Test
    public void shouldFindShortestPath() {
        Assert.assertEquals(0, finder.getShortestPath(4, 4));
        Assert.assertEquals(1, finder.getShortestPath(4, 0));
        Assert.assertEquals(2, finder.getShortestPath(0, 4));
        Assert.assertEquals(3, finder.getShortestPath(1, 2));
        Assert.assertEquals(1, finder.getShortestPath(0, 2));
    }
}
