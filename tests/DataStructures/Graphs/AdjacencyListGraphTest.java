package DataStructures.Graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdjacencyListGraphTest {
    private AdjacencyListGraph<Integer> graph ;
    @BeforeEach
    void setUp(){
        graph = new AdjacencyListGraph<>();
    }
    @Test
    void addEdge () {
        graph.addEdge(1,2);
        Assertions.assertTrue(graph.addEdge(1,3));
        Assertions.assertFalse(graph.addEdge(1,2));
    }

    @Test
    void removeEdge () {
        Assertions.assertFalse(graph.removeEdge(1,2));
        graph.addEdge(1,2);
        Assertions.assertTrue(graph.removeEdge(1,2));
    }
}