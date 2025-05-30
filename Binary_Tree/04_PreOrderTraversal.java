package Binary_Tree;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/preorder-traversal/1

// Pre-order Traversal (NLR)

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    public static void preorderTraversal(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        // Node
        list.add(root.data);
        // Left
        preorderTraversal(root.left, list);
        // Right
        preorderTraversal(root.right, list);

    }

    // Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }
}
