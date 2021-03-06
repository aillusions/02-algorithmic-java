package com.zalizniak.medium.graph.cycle;

import com.zalizniak.medium.graph.Vertex;
import org.junit.Assert;
import org.junit.Test;

public class GraphCycleDetectorTest {

    private GraphCycleDetector graphCycleDetector = new GraphCycleDetector();

    @Test
    public void testNoCycle() {

        Vertex n0 = new Vertex(0);
        Vertex n1 = new Vertex(1);
        Vertex n2 = new Vertex(2);
        Vertex n3 = new Vertex(3);
        Vertex n4 = new Vertex(4);

        n0.add(n1, n2);
        n2.add(n3);
        n3.add(n4);

        Assert.assertFalse(graphCycleDetector.hasCycle(n0));
    }
    @Test
    public void testCycle() {

        Vertex n0 = new Vertex(0);
        Vertex n1 = new Vertex(1);
        Vertex n2 = new Vertex(2);
        Vertex n3 = new Vertex(3);
        Vertex n4 = new Vertex(4);

        n0.add(n1, n2);
        n2.add(n3);
        n3.add(n4);
        n4.add(n0);

        Assert.assertTrue(graphCycleDetector.hasCycle(n0));
    }

    @Test
    public void testCycle1() {

        Vertex n0 = new Vertex(0);
        Vertex n1 = new Vertex(1);
        Vertex n2 = new Vertex(2);
        Vertex n3 = new Vertex(3);
        Vertex n4 = new Vertex(4);

        n0.add(n1, n2);
        n1.add(n2);
        n2.add(n1, n3, n4);

        Assert.assertTrue(graphCycleDetector.hasCycle(n0));
    }
}
