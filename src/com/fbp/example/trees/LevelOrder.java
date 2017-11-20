package com.fbp.example.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rajeevranganathan
 */
public class LevelOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (a == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(a);
        int size = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
            list.add(curNode.val);
            if (--size == 0) {
                ans.add(new ArrayList<>(list));
                list.clear();
                size = queue.size();//reset to queue size
            }
        }
        return ans;
    }

}
