package com.zalizniak.depthfirstsearch;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
public class Node {

    //    A Unique Identifier for our node
    public String stationName;
    //    An arraylist containing a list of Nodes that
    //    This node is directly connected to - It's child nodes.

    @ToString.Exclude
    Node leftChild;

    @ToString.Exclude
    Node rightChild;

    public Node(String stationName, Node firstChild, Node secondChild) {
        this.stationName = stationName;
        this.leftChild = firstChild;
        this.rightChild = secondChild;
    }

    public ArrayList<Node> getChildren() {
        ArrayList<Node> childNodes = new ArrayList<>();
        if (this.leftChild != null) {
            childNodes.add(leftChild);
        }
        if (this.rightChild != null) {
            childNodes.add(rightChild);
        }
        return childNodes;
    }
}
