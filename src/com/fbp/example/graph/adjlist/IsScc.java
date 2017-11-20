package com.fbp.example.graph.adjlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Kosarajus method of checking if a graph is Strongly connected
 * Created by rajeevranganathan on 25/10/17 for TheLastChance.
 * O(V+E)
 */
public class IsScc {
    Graph graph;

    public IsScc(int v) {
        graph = new Graph(v);
    }

    public void add(int u, int v) {
        if (graph == null)
            throw new IllegalStateException("Graph is null");
        graph.add(u, v);
    }

    class Graph {
        public int V;
        public LinkedList<Integer> adj[];

        public Graph(int v) {
            V = v;
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void add(int u, int v) {
            adj[u].add(v);
        }
    }

    private Graph transposed(Graph oldGraph) {
        Graph graph = new Graph(oldGraph.V);
        for (int i = 0; i < oldGraph.V; i++) {
            Iterator<Integer> it = graph.adj[i].listIterator();
            if (it.hasNext()) {
                graph.adj[it.next()].add(i);
            }
        }
        return graph;

    }

    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            v = stack.peek();
            v = -1;
            Iterator<Integer> it = graph.adj[v].listIterator();
            while (it.hasNext()) {
                if (!visited[it.next()]) {
                    v = it.next();
                    break;
                }
            }
            if (v == -1)
                stack.pop();
            else {
                visited[v] = true;
                stack.push(v);
            }
        }
    }

    public boolean isScc() {
        boolean[] visited = new boolean[graph.V];
        Arrays.fill(visited, false);

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i])
                return false;
        }
        Arrays.fill(visited, true);

        Graph newGraph = transposed(graph);
        IsScc newInstance = new IsScc(graph.V);
        newInstance.graph = newGraph;

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                newInstance.DFSUtil(i, visited);
            }
        }

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i])
                return false;
        }

        return true;

    }


}
