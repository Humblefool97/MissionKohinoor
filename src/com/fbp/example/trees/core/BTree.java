package com.fbp.example.trees.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajeevranganathan
 */
public class BTree {
    TreeNode root;
        ArrayList<ArrayList<Integer>> pathsList = new ArrayList<>();

    public BTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
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

    public int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return (left > right ? left : right) + 1;
    }

    public boolean isBalancedBt(TreeNode node) {
        if (root == null)
            return true;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedBt(node.left) && isBalancedBt(node.right);

    }

    public int isSameTree(TreeNode a, TreeNode b) {
        return checkIdentical(a, b) ? 1 : 0;
    }

    public boolean checkIdentical(TreeNode root1, TreeNode root2) {
        //Will be true only when both of them are leafs
        //That mean's completion of tree traversal.If you have reached leaf in both the tree(Subtree's)
        //that means that particular tree(subtree) is identical
        if (root1 == null && root2 == null) {
            return true;
        }

        //Will fail when one of the root is null or data is not proper
        if (root1 != null && root2 != null && root1.val == root2.val) {
            boolean isLeftTreeIdentical = checkIdentical(root1.left, root2.left);
            boolean isRightTreeIdentical = checkIdentical(root1.right, root2.right);
            return isLeftTreeIdentical && isRightTreeIdentical;
        }

        return false;

    }

    public int isSymmetric(TreeNode a) {
        return isSymmetric(a, a) ? 1 : 0;
    }

    public boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a != null && b != null && a.val == b.val) {
            return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
        }
        return false;
    }

    public TreeNode mirror(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = mirror(node.left);
        TreeNode right = mirror(node.right);

        node.right = left;
        node.left = right;
        return node;

    }

    public TreeNode createBalancedBst(final List<Integer> a) {

        if (a == null || a.size() == 0)
            return null;
        if (a.size() == 1)
            return new TreeNode(a.get(0));

        int array[] = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            array[i] = a.get(i);
        }

        return createBalancedBst(array, 0, array.length - 1);

    }

    public TreeNode createBalancedBst(int arr[], int start, int end) {
        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = createBalancedBst(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = createBalancedBst(arr, mid + 1, end);

        return node;
    }

    public TreeNode createTreeFromInorderAndPreOrder(int[] pre, int[] inorder) {

        return createTreeFromInorderAndPreOrder(pre, inorder, inorder.length - 1, 0, inorder.length - 1);

    }

    private TreeNode createTreeFromInorderAndPreOrder(int[] pre, int[] inorder, int index, int start, int end) {
        if (start > end || (index + 1 >= inorder.length))
            return null;

        TreeNode node = new TreeNode(pre[index++]);
        if (start == end)
            return node;
        int searchIndex = search(inorder, node.val);
        node.left = createTreeFromInorderAndPreOrder(pre, inorder, index, start, searchIndex - 1);
        node.right = createTreeFromInorderAndPreOrder(pre, inorder, index, searchIndex + 1, end);

        return node;

    }

    private TreeNode createTreeFromInorderAndPostOrder(int[] pre, int[] inorder, int index, int start, int end) {
        if (start > end || (index + 1 >= inorder.length))
            return null;

        TreeNode node = new TreeNode(pre[index--]);
        if (start == end)
            return node;
        int searchIndex = search(inorder, node.val);
        node.left = createTreeFromInorderAndPreOrder(pre, inorder, index, start, searchIndex - 1);
        node.right = createTreeFromInorderAndPreOrder(pre, inorder, index, searchIndex + 1, end);

        return node;

    }


    private int search(int[] in, int key) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == key)
                return i;
        }

        return -1;
    }


    public int findLca(TreeNode root, int n1, int n2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2))
            return -1;

        int i = 0;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!(path1.get(i).equals(path2.get(i))))
                break;
        }

        return path1.get(i - 1);
    }

    private boolean findPath(TreeNode root, int n, List<Integer> path) {
        if (root == null)
            return false;
        path.add(root.val);

        if (root.val == n)
            return true;
        if (root.left != null && findPath(root.left, n, path))
            return true;
        if (root.right != null && findPath(root.right, n, path))
            return true;

        path.remove(path.size() - 1);
        return false;

    }

    private void rootToLeafPath(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.val);

            if (root.left == null && root.right == null)
                pathsList.add(list);
            else {
                rootToLeafPath(root.left, new ArrayList<Integer>(list));
                rootToLeafPath(root.right, new ArrayList<Integer>(list));
            }
        }
    }

    public void printRootToLeafPaths(TreeNode root) {

        rootToLeafPath(root, new ArrayList<Integer>());

        for (ArrayList<Integer> path : pathsList) {
            for (Integer data : path) {
                System.out.print(data + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

     An example is the root-to-leaf path 1->2->3 which represents the number 123.

     Find the total sum of all root-to-leaf numbers % 1003.
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        rootToLeafPath(root,new ArrayList<Integer>());
        int sum = 0;
        for(ArrayList<Integer>pathList:pathsList){
            int pathSum=0;
            for(Integer val:pathList){
                pathSum=val+pathSum*10;
            }
            sum+=pathSum;
        }

        return sum%1003;
    }


}
