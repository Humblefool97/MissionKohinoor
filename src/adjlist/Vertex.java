package adjlist;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    long id;
    T data;

    List<Vertex<T>> adjVertexList = new ArrayList<>();
    List<Edge<T>> edgeList = new ArrayList<>();

    public Vertex(long id) {
        this.id = id;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addEdge(Vertex<T> v, Edge<T> edge) {
        adjVertexList.add(v);
        edgeList.add(edge);
    }

    public List<Edge<T>> getEdgeList() {
        return edgeList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Vertex))
            return false;
        Vertex vertex = (Vertex) obj;
        return id == vertex.id;

    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result*prime+(int)(id ^ (id >>> 32));
        return result;
    }
}
