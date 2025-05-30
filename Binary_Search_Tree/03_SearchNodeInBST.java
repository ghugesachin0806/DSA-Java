package Binary_Search_Tree;

// https://www.geeksforgeeks.org/problems/search-a-node-in-bst/1

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BST {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        // Your code here
        if (root == null)
            return false;

        if (root.data == x)
            return true;

        if (x < root.data)
            return search(root.left, x);
        else
            return search(root.right, x);
    }
}