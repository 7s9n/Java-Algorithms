package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.List;

class AdjacencyListGraph<T extends Comparable<T>>{
    private final List<Vertex> vertices;
    private class Vertex{
        private final T data;
        private final List<Vertex> adjacentVertices;
        public Vertex(T data){
            this.data = data;
            this.adjacentVertices = new LinkedList<>();
        }
        public boolean addAdjacentVertex(Vertex to) {
            for (var vertex : adjacentVertices){
                if (vertex.data.compareTo(to.data) == 0)
                    return false; // the edge already exists
            }
            return this.adjacentVertices.add(to);
        } // end of addAdjacentVertex.

        public boolean removeAdjacentVertex(T to){
            for (var vertex : adjacentVertices){
                if (vertex.data.compareTo(to) == 0){
                    this.adjacentVertices.remove(vertex);
                    return true;
                }
            }
            return false;
        } // end of removeAdjacentVertex.
        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            for (var vertex : adjacentVertices){
                str.append(vertex.data);
                str.append("->");
            }
            if (adjacentVertices.isEmpty())
                str.append("Null");
            else
                str.delete(str.length() - 2 , str.length());
            return str.toString();
        }
    } // end of class Vertex.
    public AdjacencyListGraph(){
        this.vertices = new LinkedList<>();
    }
    /**
     * This method adds an edge to the graph between two specified vertices.
     * @param from the data of the vertex the edge is from
     * @param to the data of the vertex the edge is going to
     * @return returns true if the edge did not exist, return false if it already did
     */
    public boolean addEdge(T from , T to){
        Vertex fromV = null, toV = null;
        for (var vertex : vertices){
            if (from.compareTo(vertex.data) == 0) // see if from vertex already exists
                fromV = vertex;
            if (to.compareTo(vertex.data) == 0)  // see if to vertex already exists
                toV = vertex;
            if (fromV != null && toV != null)break; // both nodes exist so stop searching
        }// end of for loop.

        if (fromV == null){
            fromV = new Vertex(from);
            vertices.add(fromV);
        }
        if (toV == null){
            toV = new Vertex(to);
            vertices.add(toV);
        }
        return fromV.addAdjacentVertex(toV);
    } // end of addEdge.

    /**
     * This method removes an edge from the graph between two specified vertices
     * @param from the data of the vertex the edge is from
     * @param to the data of the vertex the edge is going to
     * @return returns false if the edge doesn't exist, returns true if the edge exists and is removed
     */
    public boolean removeEdge(T from , T to){
        for (var vertex : vertices){
            if (from.compareTo(vertex.data) == 0)
                return vertex.removeAdjacentVertex(to);
        }
        return false;
    }// end of removeEdge
    /**
     * This gives a list of vertices in the graph and their adjacencies
     * @return returns a string describing this graph
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (var vertex : vertices){
            str.append("Vertex: ");
            str.append(vertex.data);
            str.append("\nadjacent vertices: ");
            str.append(vertex);
            str.append("\n");
        }
        return str.toString();
    }
}
public class Graph {
    public static void main (String[] args) {
            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        assert graph.addEdge(1,2);
        assert !graph.addEdge(1,2);
        assert !graph.removeEdge(2,1);
        assert graph.addEdge(1,3);
        assert graph.addEdge(3,1);
        assert graph.addEdge(3,2);
        assert graph.addEdge(3,3);
        assert graph.addEdge(3,4);
        assert graph.addEdge(3,5);
        assert graph.addEdge(3,6);
        assert graph.removeEdge(3,3);
        System.out.println(graph);
        //assert graph.addEdge(1,2);
    }
}
