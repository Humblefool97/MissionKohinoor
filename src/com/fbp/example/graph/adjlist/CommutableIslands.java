package com.fbp.example.graph.adjlist;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/commutable-islands/
 *
 * Created by rajeevranganathan on 25/10/17 for TheLastChance.
 */
public class CommutableIslands {
    List<Edge>edgeList=new ArrayList<>();

    class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int w;

        public Edge(int src, int dest, int w) {
            this.src = src;
            this.dest = dest;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }


    class DisjointSet {
        Map<Integer, Node> set = new HashMap<>();

        class Node {
            int id;
            Node parent;
            int rank;
        }

        public void makeSet(int id) {
            Node node = new Node();
            node.id = id;
            node.parent = node;
            node.rank = 0;
            set.put(id, node);
        }

        public Node findSet(Node child) {
            Node parent = child.parent;
            if (parent == child)
                return parent;
            child.parent = findSet(child.parent);
            return child.parent;
        }

        public boolean union(int v1, int v2) {
            Node p1 = findSet(set.get(v1));
            Node p2 = findSet(set.get(v2));

            if (p1 == p2)
                return false;

            if (p1.rank >= p2.rank) {
                p1.rank = p1.rank == p2.rank ? p1.rank + 1: p1.rank;
                p2.parent = p1;
            } else {
                p2.parent = p1;
            }

            return true;
        }
    }

    public int kruskalsMst(){
        Collections.sort(edgeList);
        int n=edgeList.size();
        DisjointSet disjointSet= new DisjointSet();

        for(Edge edge:edgeList){
            disjointSet.makeSet(edge.src);
            disjointSet.makeSet(edge.dest);
        }
        int sum =0;
        for (Edge edge:edgeList){
            if(disjointSet.union(edge.src,edge.dest)){
                sum+=edge.w;
            }
        }

        return sum;


    }


    /**
     *   Number of islands ( n ) = 4
        1 2 1
        2 3 4
        1 4 3
        4 3 2
        1 3 10

     Line 1 ( Corresponds to arg 1 ) : A single integer

     Line 2 ( Corresponds to arg 2 ) : 2 D array. First 2 integers R, C are the number of rows and columns. Then R * C integers follow corresponding to the rowwise numbers in the 2D array

     * @param A
     * @param B
     * @return
     */
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        for(int i=0;i<B.size();i++){
            edgeList.add(new Edge(B.get(i).get(0),B.get(i).get(1),B.get(i).get(2)));
        }

        return kruskalsMst();
    }
}
