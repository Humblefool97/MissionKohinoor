package com.fbp.example.trees.core;

/**
 * Created by rajeevranganathan
 */
public class TreeNode {
    public int val;
    public TreeNode left;
   public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public void add(int val) {
        if (left == null) {
            left = new TreeNode(val);
        } else if (right == null) {
            right = new TreeNode(val);
        } else {
            if (getCount(left) <= getCount(right)) {
                left.add(val);
            } else {
                right.add(val);
            }
        }
    }

    public TreeNode add(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
        } else if (val < node.val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.left, val);
        }

        return node;
    }


    private int getCount(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int count = 1;
            count += getCount(root.left);
            count += getCount(root.right);
            return count;
        }
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getVal() {
        return val;
    }


}
