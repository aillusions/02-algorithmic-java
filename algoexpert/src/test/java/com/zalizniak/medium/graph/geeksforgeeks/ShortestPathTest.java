package com.zalizniak.medium.graph.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

public class ShortestPathTest {

    private ShortestPath finder = new ShortestPath();

    @Test
    public void shouldFindShortestPath() {
        //Assert.assertEquals(1, finder.getShortestPath(4, 0));
        Assert.assertEquals(2, finder.getShortestPath(0, 4));
        //Assert.assertEquals(3, finder.getShortestPath(1, 2));
        //Assert.assertEquals(1, finder.getShortestPath(0, 2));
    }
}
