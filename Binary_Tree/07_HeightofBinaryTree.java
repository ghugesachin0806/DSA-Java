package Binary_Tree;

// https://www.geeksforgeeks.org/problems/height-of-binary-tree/1

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Function to find the height of a binary tree.
    int solve(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;

        return Math.max(solve(root.left), solve(root.right)) + 1;
    }

    int height(Node node) {
        // code here
        return solve(node);
    }
}

// Here we are visiting each node single time so , 
// Time complexity --> O(n)

// space taken by recursion will be in stack and max space taken is max. height of tree
// Space complexity --> O(height)