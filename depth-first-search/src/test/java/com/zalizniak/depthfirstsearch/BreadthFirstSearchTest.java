package com.zalizniak.depthfirstsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BreadthFirstSearchTest {

    @Test
    public void testSearch() {
        Node station1 = new Node("Westminster", null, null);
        Node station2 = new Node("Waterloo", station1, null);
        Node station3 = new Node("Trafalgar Square", station1, station2);
        Node station4 = new Node("Canary Wharf", station2, station3);
        Node station5 = new Node("London Bridge", station4, station3);
        Node station6 = new Node("Tottenham Court Road", station5, station4);

        BreadthFirstSearch bfs = new BreadthFirstSearch(station6, station1);

        if (bfs.compute()) {
            log.info("Path Found!");
        }
    }
}
