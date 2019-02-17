package com.zalizniak.graphshortestpath.dijkstra;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

@Slf4j
public class DijkstraTest {

    @Test
    public void testPath() {
        // mark all the vertices
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex D = new Vertex("D");
        Vertex F = new Vertex("F");
        Vertex K = new Vertex("K");
        Vertex J = new Vertex("J");
        Vertex M = new Vertex("M");
        Vertex O = new Vertex("O");
        Vertex P = new Vertex("P");
        Vertex R = new Vertex("R");
        Vertex Z = new Vertex("Z");

        // set the edges and weight
        A.adjacencies = new Edge[]{new Edge(M, 8)};
        B.adjacencies = new Edge[]{new Edge(D, 11)};
        D.adjacencies = new Edge[]{new Edge(B, 11)};
        F.adjacencies = new Edge[]{new Edge(K, 23)};
        K.adjacencies = new Edge[]{new Edge(O, 40)};
        J.adjacencies = new Edge[]{new Edge(K, 25)};
        M.adjacencies = new Edge[]{new Edge(R, 8)};
        O.adjacencies = new Edge[]{new Edge(K, 40)};
        P.adjacencies = new Edge[]{new Edge(Z, 18)};
        R.adjacencies = new Edge[]{new Edge(P, 15)};
        Z.adjacencies = new Edge[]{new Edge(P, 18)};


        Dijkstra.computePaths(A);
        System.out.println("Distance to " + Z + ": " + Z.minDistance);
        List<Vertex> path = Dijkstra.getShortestPathTo(Z);
        System.out.println("Path: " + path);
        Assert.assertEquals("[A, M, R, P, Z]", path.toString());
    }
}
