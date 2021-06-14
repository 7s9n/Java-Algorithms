package DataStructures.Graphs;

import java.util.*;

class Graph <T extends Comparable<T>>{
    private class Edge{
        T startVertex , endVertex;
        public Edge(T startVertex , T endVertex){
            this.startVertex = startVertex;
            this.endVertex = endVertex;
        }
    } // end of class Edge
    // map for representing the graph
    private final Map<T , List<Edge>> container;

    public Graph(){
        container = new HashMap<>();
    }
    public boolean addVertex(T v){
        if (container.containsKey(v))
            return false;

        container.put(v , null);
        return true;
    }
    public boolean addEdge(T startVertex , T endVertex){
        List<Edge> list = container.get(startVertex);
        if (! (container.containsKey(endVertex)) ){
            container.put(endVertex , null);
        }
        if (list == null){
            list = new LinkedList<>();
            list.add(new Edge(startVertex , endVertex));
            container.put(startVertex , list);
            return true;
        }
        if (!isEdgeExist(startVertex , endVertex , list))
            return list.add(new Edge(startVertex , endVertex));
        return false;
    }
    public boolean isEdgeExist(T startVertex , T endVertex){
        return isEdgeExist(startVertex , endVertex , container.get(startVertex));
    }
    private boolean isEdgeExist(T startVertex , T endVertex , List<Edge> list){
        if (list == null)
            return false;
        for (Edge edge : list){
            if (edge.startVertex.compareTo(startVertex) == 0 && edge.endVertex.compareTo(endVertex) ==0){
                return true;
            } // end if
        } // end for each
        return false;
    }
    public int countComponents(){
        int counter = 0;
        Set<T> markedVertices = new HashSet<>();
        Set<T> vertices = container.keySet();
        for (T vertex : vertices){
            if (!( markedVertices.contains(vertex)) ){
                markedVertices.add(vertex);
                markedVertices.addAll(dfs(vertex));
                ++counter;
            }// end if
        }
        return counter;
    }
    public List<T> dfs(T v){
        return dfs(v , new LinkedList<>());
    }
    private List<T> dfs(T v , List<T> visited){
        visited.add(v);
        List<Edge> edgeList = container.get(v);
        if (edgeList != null){
            for (Edge edge : edgeList){
                if (! (visited.contains(edge.endVertex)) ){
                    dfs(edge.endVertex , visited);
                }// end if ! (visited.contains(edge.endVertex))
            } // end for each
        }// end if edgeList != null
        return visited;
    }
}
public class ConnectedComponents {
    public static void main (String[] args) {
        Graph<Integer> integerGraph = new Graph<>();
        integerGraph.addEdge(1, 2);
        integerGraph.addEdge(2, 3);
        integerGraph.addEdge(2, 4);
        integerGraph.addEdge(3, 5);

        integerGraph.addEdge(7, 8);
        integerGraph.addEdge(8, 10);
        integerGraph.addEdge(10, 8);

        Graph<Character> characterGraph = new Graph<>();
        characterGraph.addEdge('a', 'b');
        characterGraph.addEdge('a', 'e');
        characterGraph.addEdge('b', 'e');
        characterGraph.addEdge('b', 'c');
        characterGraph.addEdge('c', 'd');
        characterGraph.addEdge('d', 'a');

        characterGraph.addEdge('x', 'y');
        characterGraph.addEdge('x', 'z');

        characterGraph.addVertex('w');
        characterGraph.addEdge('w', 'w');


        System.out.println("Number of components: " + integerGraph.countComponents());
        System.out.println("Number of components: " + characterGraph.countComponents());
    }
}
