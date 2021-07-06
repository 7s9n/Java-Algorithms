package DataStructures.Graphs;

import java.util.*;

public class DepthFirstSearch<T extends Comparable<T>> {
    private final MapGraph<T> graph ;

    public DepthFirstSearch(){
        graph = new MapGraph<>();
    }
    public void add(T from , T to){
        graph.addEdge(from , to);
    }

    public List<T> dfs(T start){
        if (!graph.contains(start)){
            throw new NoSuchElementException(start + " doesn't exist in the graph");
        }
        Map<T, List<T>> graphContainer = graph.getContainer();
        HashSet<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        List<T> dfsTraversal = new ArrayList<>();

        stack.add(start);

        while (!stack.empty()){
            T vertex = stack.pop();
            visited.add(vertex);
            dfsTraversal.add(vertex);
            List<T> adjacentVertices = graphContainer.get(vertex);

            if (adjacentVertices != null){
                for (T adjacentVertex : adjacentVertices){
                    if (!visited.contains(adjacentVertex)){
                        stack.add(adjacentVertex);
                    }
                }
            }
        }
        return dfsTraversal;
    }
    public int countComponent(){
        int cnt = 0;
        var vertices = graph.getContainer().keySet();
        Set<T> markedVertices = new HashSet<>();
        for (T vertex : vertices){
            if(!markedVertices.contains(vertex)){
                markedVertices.add(vertex);
                markedVertices.addAll(this.dfs(vertex));
                cnt++;
            }
        }
        return cnt;
    }

    public static void main (String[] args) {
        DepthFirstSearch<Integer> g = new DepthFirstSearch<>();
        g.add(0, 1);
        g.add(0, 2);
        g.add(1, 2);
        g.add(2, 0);
        g.add(2, 3);
        g.add(3, 3);

        System.out.println(g.dfs(1));
        System.out.println(g.countComponent());
    }
}
