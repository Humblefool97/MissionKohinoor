package com.fbp.example.trees.core;

import java.util.ArrayList;

/**
 * Created by rajeevranganathan on 08/10/17 for TheLastChance.
 */
public class BTree {
    TreeNode root;

    public BTree() {
        root = null;
    }

    public void insert(int val, boolean isBst) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            if (isBst)
                root.add(val);
            else
                root.add(root, val);
        }
    }


    public int isValidBST(TreeNode a) {
        return isBst(a, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isBst(TreeNode node, int min, int max) {
        if (node == null)
            return true;

        if ((node.getVal() <= min) || (node.getVal() >= max))
            return false;
        return (isBst(node.getLeft(), min, node.getVal()) && isBst(node.getRight(), node.getVal(), max));
    }

    public ArrayList<Integer> inOrderTraversal(TreeNode a) {
        ArrayList<Integer> resultList = new ArrayList<>();
        return inOrderTraversal(a, resultList);

    }

    public ArrayList<Integer> inOrderTraversal(TreeNode a, ArrayList<Integer> result) {
        if (a == null)
            return result;
        inOrderTraversal(a.getLeft(), result);
        result.add(a.getVal());
        inOrderTraversal(a.getRight(), result);

        return result;

    }

    public ArrayList<Integer> postOrderTraversal(TreeNode a, ArrayList<Integer> result) {
        if (a == null)
            return result;
        postOrderTraversal(a.getLeft(), result);
        postOrderTraversal(a.getRight(), result);
        result.add(a.getVal());

        return result;

    }

    public ArrayList<Integer> preOrderTraversal(TreeNode a, ArrayList<Integer> result) {
        if (a == null)
            return result;

        result.add(a.getVal());
        preOrderTraversal(a.getLeft(), result);
        preOrderTraversal(a.getRight(), result);

        return result;
    }

    public TreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }
}
