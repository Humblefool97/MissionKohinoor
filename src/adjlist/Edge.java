package adjlist;

public class Edge<T> {
    Vertex<T> v1;
    Vertex<T> v2;

    boolean isDirected;
    int weight;


    public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
        v1 = vertex1;
        v2 = vertex2;
    }

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
        v1 = vertex1;
        v2 = vertex2;
        this.isDirected = isDirected;
    }

    public Edge(Vertex<T> v1, Vertex<T> v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Edge(Vertex<T> v1, Vertex<T> v2, boolean isDirected, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.isDirected = isDirected;
        this.weight = weight;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public int getWeight() {
        return weight;
    }

}
