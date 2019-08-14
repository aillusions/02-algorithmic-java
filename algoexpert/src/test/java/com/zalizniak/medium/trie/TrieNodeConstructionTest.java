package com.zalizniak.medium.trie;

import org.junit.Test;

public class TrieNodeConstructionTest {

    @Test
    public void test() {

        TrieNode root = new TrieNode();

        {
            TrieNode node_2 = new TrieNode(false);
            root.nodes.put('C', node_2);

            TrieNode node_3 = new TrieNode(false);
            node_2.nodes.put('A', node_3);

            TrieNode node_4 = new TrieNode(true);
            node_3.nodes.put('R', node_4);
        }

        {
            TrieNode node_5 = new TrieNode(false);
            root.nodes.put('D', node_5);

            TrieNode node_6 = new TrieNode(false);
            node_5.nodes.put('O', node_6);

            TrieNode node_7 = new TrieNode(false);
            node_6.nodes.put('N', node_7);

            TrieNode node_8 = new TrieNode(true);
            node_7.nodes.put('E', node_8);
        }
    }
}
