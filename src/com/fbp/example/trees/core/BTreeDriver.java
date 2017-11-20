package com.fbp.example.trees.core;

/**
 * Created by rajeevranganathan
 */
public class BTreeDriver {
    public static void main(String[] args) {
        BTree bTree = new BTree();

      /*  bTree.insert(85, true);
        bTree.insert(10, true);
        bTree.insert(95, true);
        bTree.insert(5, true);
        bTree.insert(20, true);
        bTree.insert(86, true);
        bTree.insert(97, true);


        System.out.println(bTree.inOrderTraversal(bTree.getRoot()));*/

      /*  int arr[] = {1, 2};
        bTree = new BTree();
        System.out.println(bTree.inOrderTraversal(bTree.createBalancedBst(arr, 0, 1)));
*/
        bTree = new BTree();
        bTree.root = new TreeNode(10);
        bTree.root.left = new TreeNode(8);
        bTree.root.right = new TreeNode(2);
        bTree.root.left.left = new TreeNode(3);
        bTree.root.left.right = new TreeNode(5);
        bTree.root.right.left = new TreeNode(2);

        bTree.printRootToLeafPaths(bTree.root);
    }
}
