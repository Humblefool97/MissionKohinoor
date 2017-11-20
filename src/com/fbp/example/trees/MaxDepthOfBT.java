package com.fbp.example.trees;

import com.fbp.example.trees.core.TreeNode;

import java.util.ArrayList;

/**
 * Created by rajeevranganathan
 */
public class MaxDepthOfBT {
    static int max = 0;

    public int maxDepth(TreeNode root) {
        maxDepthUtil(root, new ArrayList<Integer>());
        return max;
    }

    public void maxDepthUtil(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.val);

            if (root.left == null && root.right == null) {
                if (list.size() > max)
                    max = list.size();
            } else {
                maxDepthUtil(root.left, new ArrayList<Integer>(list));
                maxDepthUtil(root.right, new ArrayList<Integer>());
            }
        }
    }
}
