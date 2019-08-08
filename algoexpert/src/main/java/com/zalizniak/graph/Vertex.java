package com.zalizniak.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Vertex {

    protected Integer label;
    protected List<Vertex> vertices = new LinkedList<>();

    public Vertex(Integer label) {
        this.label = label;
    }

    public void add(Vertex... nodes) {
        vertices.addAll(Arrays.asList(nodes));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
