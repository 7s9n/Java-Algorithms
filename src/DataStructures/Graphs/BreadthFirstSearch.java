package DataStructures.Graphs;

import java.util.*;

public class BreadthFirstSearch<T extends Comparable<T>> {
    private final MapGraph<T> graph;

    public BreadthFirstSearch(){
        graph = new MapGraph<>();
    }
    public void add(T from , T to){
        graph.addEdge(from , to);
    }
    public List<T> bfs(T start){
        if(!graph.contains(start)){
            throw new NoSuchElementException(start + " doesn't exist in the graph");
        }
        Map<T, List<T>> graphContainer = graph.getContainer();
        HashSet<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        List<T> bfsTraversal = new ArrayList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            T vertex = queue.poll();

            bfsTraversal.add(vertex);

            List<T> neighbours = graphContainer.get(vertex);
            if (neighbours != null){
                for (T next : neighbours){
                    if (!visited.contains(next)){
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

        }
        return bfsTraversal;
    }

    public static void main (String[] args) {
        BreadthFirstSearch<Integer> g = new BreadthFirstSearch<>();

        g.add(0, 1);
        g.add(0, 2);
        g.add(1, 2);
        g.add(2, 0);
        g.add(2, 3);
        g.add(3, 3);
        System.out.println(g.bfs(1));
    }
}
