package Binary_Tree;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/postorder-traversal/1

// Post-order Traversal (LRN)

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    public void postOrderTraversal(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        // Left
        postOrderTraversal(root.left, list);
        // Right
        postOrderTraversal(root.right, list);
        // Node
        list.add(root.data);
    }

    // Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root) {
        // Your code goes here
        ArrayList<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }
}
