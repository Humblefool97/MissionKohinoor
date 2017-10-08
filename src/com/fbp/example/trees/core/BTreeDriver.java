package com.fbp.example.trees.core;

/**
 * Created by rajeevranganathan on 08/10/17 for TheLastChance.
 */
public class BTreeDriver {
    public static void main(String[] args) {
        BTree bTree = new BTree();

        bTree.insert(85, true);
        bTree.insert(10, true);
        bTree.insert(95, true);
        bTree.insert(5, true);
        bTree.insert(20, true);
        bTree.insert(86, true);
        bTree.insert(97, true);


        System.out.println(bTree.inOrderTraversal(bTree.getRoot()));


    }
}
