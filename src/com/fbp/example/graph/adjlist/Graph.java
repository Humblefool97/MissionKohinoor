package com.fbp.example.graph.adjlist;


import java.util.*;

public class Graph<T> {

    Map<Integer, Vertex<T>> allVertex;
    List<Edge<T>> allEdges;
    boolean isDirected;

    public Graph(boolean isDirected) {
        this.allVertex = new HashMap<>();
        this.allEdges = new ArrayList<>();
        this.isDirected = isDirected;
    }


    public void addEdge(int id1, int id2) {
        addEdge(id1, id2, 0);
    }

    public void addEdge(int id1, int id2, int weight) {
        //Search for V1,V2,if it is there leave
        //else add it
        Vertex<T> v1 = getVertexById(id1);
        Vertex<T> v2 = getVertexById(id2);

        //Create Edge
        Edge<T> edge = new Edge<T>(v1, v2, isDirected, weight);
        v1.addEdge(v2, edge);
        if (!isDirected)
            v2.addEdge(v1, edge);

        allEdges.add(edge);

    }

    private Vertex<T> getVertexById(int id1) {
        Vertex<T> v1 = null;
        if (allVertex.containsKey(id1)) {
            v1 = allVertex.get(id1);
        } else {
            v1 = new Vertex(id1);
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

    public Map<Integer, Vertex<T>> getAllVertex() {
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

    public int getDegree() {
        return allVertex.size();
    }

    /**
     * O(V+E),O(V)
     *
     * @param v startVertex
     */

    public void dfs(Vertex<T> v) {
        System.out.println("/**********DFS************/");

        boolean[] visited = new boolean[getDegree()];
        Arrays.fill(visited, false);

        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(v);
        visited[v.getId()] = true;
        System.out.println(v.getId());

        while (!stack.isEmpty()) {
            v = stack.peek();

            v = getAdjacentVertex(v, visited);
            if (v == null)
                stack.pop();
            else {
                stack.push(v);
                visited[v.getId()] = true;
                System.out.println(v.getId());
            }
        }
    }

    private Vertex<T> getAdjacentVertex(Vertex<T> v, boolean[] visited) {
        List<Vertex<T>> vertexList = v.getAdjVertexList();
        Iterator<Vertex<T>> it = vertexList.listIterator();
        while (it.hasNext()) {
            Vertex<T> n = it.next();
            if (!visited[n.getId()])
                return n;
        }
        return null;
    }

    public void bfs(Vertex<T> v) {
        System.out.println("/**********BFS************/");

        boolean[] visited = new boolean[getDegree()];
        Arrays.fill(visited, false);

        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(v);
        visited[v.getId()] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.println(v.getId());

            List<Vertex<T>> adjVertexList = v.getAdjVertexList();
            Iterator<Vertex<T>> it = adjVertexList.listIterator();
            while (it.hasNext()) {
                Vertex<T> n = allVertex.get(it.next().getId());
                if (!visited[n.getId()]) {
                    visited[n.getId()] = true;
                    queue.add(n);
                }
            }
        }
    }


    public boolean hasLoopUsingDisjointSet() {
        DisjointSet<T> ds = new DisjointSet<>();
        //Make set for all the vertices
        for (Vertex<T> vertex : getAllVertex().values()) {
            ds.makeSet(vertex);
        }
        //for each edge,get v1 & v2
        for (Edge<T> edge : getAllEdges()) {
            Vertex<T> v1 = edge.v1;
            Vertex<T> v2 = edge.v2;
            if (!ds.union(v1.getId(), v2.getId()))
                return true;
        }
        return false;
    }

    public boolean hasLoopUsingDfs() {
        boolean visited[] = new boolean[getDegree()];
        Arrays.fill(visited, false);

        for (Vertex<T> adjVertex : getAllVertex().values()) {
            if (!visited[adjVertex.getId()]) {
                if (hasLoop(adjVertex, visited, null))
                    return true;
            }
        }
        return false;

    }

    private boolean hasLoopUsingDfs(Vertex<T> vertex, boolean[] visited, Vertex<T> parent) {
        visited[vertex.getId()] = true;
        for (Vertex<T> adjVertex : vertex.getAdjVertexList()) {
            if (!visited[vertex.getId()] && hasLoopUsingDfs(adjVertex, visited, vertex))
                return true;
            else if (parent == adjVertex)
                return true;
        }
        return false;
    }

    public boolean hasLoopForDirectedGraph() {
        return false;
    }


    private boolean hasLoop(Vertex<T> vertex, boolean[] visited, boolean[] recStack) {
        if (!visited[vertex.getId()]) {
            visited[vertex.getId()] = true;
            recStack[vertex.getId()] = true;

            for (Vertex<T> adjVertex : vertex.getAdjVertexList()) {
                if (!visited[adjVertex.getId()] && hasLoop(adjVertex, visited, recStack))
                    return true;
                else if (recStack[vertex.getId()])
                    return true;
            }
        }

        recStack[vertex.getId()] = false;
        return false;
    }


    /**
     * Finding MST using Kruskal's algorithm with Disjoint set
     *
     * @return
     */
    private Edge<T>[] mstWithDisjointSet() {
        List<Edge<T>> edgeList = getAllEdges();
        Collections.sort(edgeList, new EdgeComparator());

        Edge<T>[] result = new Edge[getDegree() - 1];
        Arrays.fill(result, null);

        DisjointSet<T> ds = new DisjointSet<>();
        for (Vertex<T> vertex : getAllVertex().values()) {
            ds.makeSet(vertex);
        }

        int index = 0;
        for (Edge<T> edge : getAllEdges()) {
            if (ds.union(edge.v1.getId(), edge.v2.getId())) {
                result[index++] = edge;
            }
        }
        if (index != 0)
            return result;

        return null;

    }

    class EdgeComparator implements Comparator<Edge<T>> {

        @Override
        public int compare(Edge<T> edge1, Edge<T> edge2) {
            if (edge1.weight <= edge2.weight)
                return -1;

            return 1;
        }
    }
}
