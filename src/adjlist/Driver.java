package adjlist;

/**
 * Created by rajeevranganathan on 11/09/17 for MissionKohinoor.
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

    }
}
