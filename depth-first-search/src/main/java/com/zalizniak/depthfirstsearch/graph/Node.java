package com.zalizniak.depthfirstsearch.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    int data;
    boolean visited;
    List<Node> neighbours;

    Node(int data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Node neighbourNode) {
        this.neighbours.add(neighbourNode);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }
}