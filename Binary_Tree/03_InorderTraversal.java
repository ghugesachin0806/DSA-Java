package Binary_Tree;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/inorder-traversal/1

// In-order Traversal (LNR)

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    public void inorderTraversal(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        // Left
        inorderTraversal(root.left, list);
        // Node
        list.add(root.data);
        // Right
        inorderTraversal(root.right, list);
    }

    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        return list;
    }
}
