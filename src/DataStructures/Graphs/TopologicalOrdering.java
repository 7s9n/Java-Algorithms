package DataStructures.Graphs;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Implementation of Kahn's algorithm to find a topological ordering
 *
 * <p>Kahn's algorithm finds a topological ordering by iteratively removing nodes in the graph which
 * have no incoming edges. When a node is removed from the graph, it is added to the topological
 * ordering and all its edges are removed allowing for the next set of nodes with no incoming edges
 * to be selected.
 *

 * <p>Time complexity: O(V+E)
 *
 * @author Hussein Sarea, zzzsssx0@gmail.com
 */

public class TopologicalOrdering {
    private static <T> Map<T , Integer> getInDegree(Map<T , List<T>> container){
        Map<T , Integer> inDegree = new HashMap<>();
        for (T v : container.keySet()){
            List<T> adjacentVertices = container.get(v);
            if (adjacentVertices != null){
                for (T to : adjacentVertices){
                    inDegree.compute(to , (key , value)-> value == null ? 1 : value + 1);
                }
            } // end if adjacentVertices != null
        } // end outer loop
        return inDegree;
    }
    public static <T> List<T> topologicalOrdering(Map<T , List<T>> container){
        //Begin by counting the incoming degree of each vertex.
        Map<T , Integer> inDegree = getInDegree(container);

        // queue always contains the set nodes with no incoming edges.
        Queue<T> queue = new LinkedList<>();

        // Add all vertices with a degree of 0 (no incoming edges)
        // to the queue. These are all the vertices in the graph with no dependencies.
        for (T v : container.keySet()){
            if (inDegree.get(v) == null)
                queue.add(v);
        }
        List<T> order = new LinkedList<>();
        while (!queue.isEmpty()) {
            // remove a vertex from the front of the queue and add it to the topological ordering.
            T v = queue.poll();
            order.add(v);
            // decrease the degree of all affected vertices.
            List<T> adjacentVertices = container.get(v);
            if (adjacentVertices != null) {
                for (T adjacent : adjacentVertices) {
                    inDegree.compute(adjacent, (key, value) -> value == null ? 0 : value - 1);
                    if (inDegree.get(adjacent) == 0) {
                        queue.add(adjacent); // add any new node with incoming degree of 0 to the queue.
                    } // end if inDegree.get(adjacent) == 0
                } // end inner loop.
            } // end if adjacentVertices != null.
        }// end while.
        if (order.size() != container.size()){
            throw new IllegalArgumentException("Graph is not acyclic! Detected a cycle.");
        }
        return order;
    }// end of topologicalOrdering function.
    public static void main (String[] args) {
        MapGraph<Integer> graph = new MapGraph<>();
        graph.addVertex(13);
        graph.addEdge(0 , 2);
        graph.addEdge(0 , 3);
        graph.addEdge(0 , 6);
        graph.addEdge(1 , 4);
        graph.addEdge(2 , 6);
        graph.addEdge(3 , 1);
        graph.addEdge(3 , 4);
        graph.addEdge(4 , 5);
        graph.addEdge(4 , 8);
        graph.addEdge(6 , 7);
        graph.addEdge(6 , 11);
        graph.addEdge(7 , 4);
        graph.addEdge(7 , 12);
        graph.addEdge(9 , 2);
        graph.addEdge(9 , 10);
        graph.addEdge(10 , 6);
        graph.addEdge(11 , 12);
        graph.addEdge(12 , 8);

        var order = topologicalOrdering(graph.getContainer()); //0 9 13 3 2 10 1 6 7 11 4 12 5 8
        System.out.println(order);

        MapGraph<Integer> graph2 = new MapGraph<>();
        graph2.addEdge(4 , 0);
        graph2.addEdge(5 , 0);
        graph2.addEdge(5 , 2);
        graph2.addEdge(4 , 1);
        graph2.addEdge(3 , 1);
        graph2.addEdge(2 , 3);




        var order2 = topologicalOrdering(graph2.getContainer());
        System.out.println(order2);

    }
}
