package com.fbp.example.graph.adjlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Print all the Strongly Connected components(Kosaraju's)
 * O(V+E)
 * Created by rajeevranganathan on 25/10/17 for TheLastChance.
 */
public class MyGraph {
    int V;
    LinkedList<Integer>[] adj;

    public MyGraph(int v) {
        this.V = v;
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    private void add(int u, int v) {
        adj[u].add(v);
    }

    private void printScc() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoLogicalSort(i, visited, stack);
            }
        }

        Arrays.fill(visited, false);
        MyGraph transposeGraph = getTranspose();

        while (stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                transposeGraph.DFSUtil(v, visited);
            }
        }

    }

    private void DFSUtil(int v, boolean visited[]) {
        Stack<Integer> stack = new Stack<>();
        visited[v] = true;
        System.out.print(v);
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.peek();
            v = getAdjacentVertex(v, visited);
            if (v == -1) {
                stack.pop();
            } else {
                visited[v] = true;
                System.out.print(v);
                stack.push(v);
            }

        }
    }


    private MyGraph getTranspose() {
        MyGraph graph = new MyGraph(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> iterator = adj[v].listIterator();
            if (iterator.hasNext()) {
                graph.adj[iterator.next()].add(v);
            }
        }

        return graph;
    }

    private void topoLogicalSort(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Iterator<Integer> iterator = adj[v].listIterator();
        while (iterator.hasNext()) {
            int adjVertex = iterator.next();
            if (!visited[adjVertex])
                topoLogicalSort(adjVertex, visited, stack);
        }

        stack.push(v);
    }

    private int getAdjacentVertex(int v, boolean[] visited) {
        for (int i = 0; i < V; i++) {
            if (!visited[i] && (adj[v].contains(i)))
                return i;
        }
        return -1;
    }
}
