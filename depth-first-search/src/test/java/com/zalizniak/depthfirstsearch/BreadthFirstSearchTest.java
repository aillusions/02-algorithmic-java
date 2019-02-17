package com.zalizniak.depthfirstsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BreadthFirstSearchTest {

    @Test
    public void testSearch() {
        Node Westminster = new Node("Westminster", null, null);
        Node Waterloo = new Node("Waterloo", Westminster, null);
        Node Trafalgar_Square = new Node("Trafalgar Square", Westminster, Waterloo);
        Node Canary_Wharf = new Node("Canary Wharf", Waterloo, Trafalgar_Square);
        Node London_Bridge = new Node("London Bridge", Canary_Wharf, Trafalgar_Square);
        Node Tottenham_Court_Road = new Node("Tottenham Court Road", London_Bridge, Canary_Wharf);

        BreadthFirstSearch bfs = new BreadthFirstSearch(Tottenham_Court_Road, Westminster);

        if (bfs.compute()) {
            log.info("Path Found!");
        }
    }
}
