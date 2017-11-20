package com.fbp.example.graph.adjlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajeevranganathan
 */
public class DisjointSet<T> {
    Map<Integer,Node> disjointSet = new HashMap<>();

    class Node{
        Vertex<T> data;
        int rank;
        Node parent;
    }

    public void makeSet(Vertex<T> vertex){
        Node node = new Node();
        node.data = vertex;
        node.rank = 0;
        node.parent = node;
        disjointSet.put(vertex.getId(),node);
    }

    public Node findSet(Node child){
        Node parent = child.parent;
        if(parent == child)
            return child;
        child.parent = findSet(parent);
        return child.parent;
    }

    public boolean union(int id1,int id2){
       Node v1= disjointSet.get(id1);
       Node v2 = disjointSet.get(id2);

       Node p1 = findSet(v1);
       Node p2 = findSet(v2);
       if(p1 == p2)
           return false;

        if(p1.rank >= p2.rank){
            p1.rank = p1.rank == p2.rank ? p1.rank+1:p1.rank;
            p2.parent = p1;
        }else{
            p1.parent = p2;
        }

        return true;
    }
}
