package com.zalizniak.graph;


import org.junit.Test;

public class VertexTest {

    @Test
    public void shouldCreateGraph() {

        Vertex n0 = new Vertex(0);
        Vertex n1 = new Vertex(1);
        Vertex n2 = new Vertex(2);
        Vertex n3 = new Vertex(3);
        Vertex n4 = new Vertex(4);
        Vertex n5 = new Vertex(5);



        n1.add(n0);
        n2.add(n1, n3);
        n3.add(n4, n5);
    }
}
