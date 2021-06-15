package DataStructures.Graphs;

import java.security.PublicKey;
import java.util.*;

public class MapGraph <T extends Comparable<T>>{
    private final Map<T , List<T>> container;
    public MapGraph(){
        this.container = new HashMap<>();
    }

    public boolean addVertex(T v){
        if (container.containsKey(v))
            return false;
        container.put(v , null);
        return true;
    }
    public boolean addEdge(T from , T to){
        List<T> list = container.get(from);
        if (! (container.containsKey(to)) ){
            container.put(to , null);
        }
        if (list == null){
            list = new LinkedList<>();
            list.add(to);
            container.put(from , list);
            return true;
        }
        if (!isEdgeExist(from , to))
            return list.add(to);

        return false;
    }
    private boolean isEdgeExist(T from , T to){
        List<T> adjacentVertices = container.get(from);
        if (adjacentVertices == null)
            return false;
        for (T v : adjacentVertices){
            if (v.compareTo(to) == 0)
                return true;
        }
        return false;
    }

    public Map<T, List<T>> getContainer () {
        return Collections.unmodifiableMap(container);
    }
}
