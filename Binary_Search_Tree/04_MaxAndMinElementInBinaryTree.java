package Binary_Search_Tree;

// https://www.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class Solution {
    public static int findMax(Node root) {
        // code here
        if (root == null)
            return 0;
        if (root.right == null)
            return root.data;

        return findMax(root.right);
    }

    public static int findMin(Node root) {

        // code here
        if (root == null)
            return 0;

        if (root.left == null)
            return root.data;

        return findMin(root.left);
    }
}