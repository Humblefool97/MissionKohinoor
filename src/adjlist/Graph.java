package adjlist;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    Map<Long, Vertex<T>> allVertex;
    List<Edge<T>> allEdges;
    boolean isDirected;

    public Graph(boolean isDirected) {
        this.allVertex = new HashMap<>();
        this.allEdges = new ArrayList<>();
        this.isDirected = isDirected;
    }


    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }

    public void addEdge(long id1, long id2, int weight) {
        //Search for V1,V2,if it is there leave
        //else add it
        Vertex<T> v1 = getVertexById(id1);
        Vertex<T> v2 = getVertexById(id2);

        //Create Edge
        Edge<T> edge = new Edge<T>(v1, v2, isDirected, weight);
        v1.addEdge(v2, edge);
        if (!isDirected)
            v2.addEdge(v1, edge);

    }

    private Vertex<T> getVertexById(long id1) {
        Vertex<T> v1 = null;
        if (allVertex.containsKey(id1)) {
            v1 = allVertex.get(id1);
        } else {
            v1 = new Vertex<>(id1);
            allVertex.put(id1, v1);
        }

        return v1;
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Map<Long, Vertex<T>> getAllVertex() {
        return allVertex;
    }

    public boolean setDataForVertex(long id, T data) {
        if (allVertex.containsKey(id)) {
            Vertex<T> v = allVertex.get(id);
            v.setData(data);
            return true;
        }

        return false;
    }

}
