package com.zalizniak.graph;


import org.junit.Assert;
import org.junit.Test;

public class VertexTest {

    @Test
    public void shouldCreateGraph() {

        Vertex n0 = new Vertex(0);
        Vertex n1 = new Vertex(1);
        Vertex n2 = new Vertex(2);
        Vertex n3 = new Vertex(3);
        Vertex n4 = new Vertex(4);

        n0.add(n1, n2);
        n1.add(n2);
        n2.add(n1, n3, n4);
    }

    @Test
    public void shouldDoDepthFirstTraversal() {
        Vertex n0 = new Vertex(0);
        Vertex n1 = new Vertex(1);
        Vertex n2 = new Vertex(2);
        Vertex n3 = new Vertex(3);
        Vertex n4 = new Vertex(4);

        n0.add(n1, n2);
        n1.add(n2);
        n2.add(n1, n3, n4);

        System.out.println(n0.depthFirstTraversal());

        Assert.assertNull(n0.depthFirstSearch(10));
        Assert.assertNotNull(n0.depthFirstSearch(4));
    }
}
