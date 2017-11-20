package com.fbp.example.graph.adjlist;

/**
 * Created by rajeevranganathan
 */
public class Driver {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 3);

        graph.dfs(graph.allVertex.get(0));
        graph.bfs(graph.allVertex.get(0));

        Graph<Integer> graph2 = new Graph<>(false);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(2, 3);

        if(graph2.hasLoopUsingDisjointSet())
            System.out.println("has loop");
        else
            System.out.println("Doesn't have loop");
    }
}
