package Binary_Tree;

// https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    int height(Node root) {

        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    int diameter(Node root) {
        // Your code here
        if (root == null)
            return 0;

        int cnt1 = diameter(root.left);
        int cnt2 = diameter(root.right);
        int cnt3 = height(root.left) + height(root.right);

        return Math.max(cnt1, Math.max(cnt2, cnt3));
    }
}

// Here due to height function call each time we get total time complexity ---> O(N2)