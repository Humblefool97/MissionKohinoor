package com.fbp.example.graph.adjlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by rajeevranganathan
 */
public class CoursePrerequisites {
    Graph graph;

    class Graph {
        int V;
        LinkedList<Integer> adj[];

        public Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < V; i++)
                adj[i] = new LinkedList<>();
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
        }
    }

    public int toplogicalSortUtil(int v, int visited[]) {
        if (visited[v] == -1)
            return 0;
        if (visited[v] == 1)
            return 1;

        visited[v]=-1;

        Iterator<Integer> iterator = graph.adj[v].listIterator();
        while (iterator.hasNext()) {
            int adj = iterator.next();
            if (toplogicalSortUtil(adj, visited) == 0)
                return 0;
        }

        visited[v] = 1;
        return 1;
    }

    public int solve(int A, ArrayList<Integer> u, ArrayList<Integer> v) {
        if (A <= 0 || u == null || v == null)
            return 0;

        graph = new Graph(A);
        for (int i = 0; i < u.size(); i++) {
            graph.addEdge(u.get(i) - 1, v.get(i) - 1);
        }

        int[] visited = new int[A];
        int result = 0;
        for (int i = 0; i < A; i++) {
            if (toplogicalSortUtil(i, visited)==0) {
                return 0;
            }
        }

        return 1;
    }


    public static void main(String[] args) {
        CoursePrerequisites obj = new CoursePrerequisites();
        int n = 3;
        ArrayList<Integer> u = new ArrayList<>();
        u.add(1);
        u.add(2);
        u.add(3);
        ArrayList<Integer> v = new ArrayList<>();
        v.add(2);
        v.add(3);
        v.add(1);

        System.out.println(obj.solve(n, u, v));

    }

}
