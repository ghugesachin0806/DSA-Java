package Binary_Tree;

import java.util.AbstractMap.SimpleEntry;

// https://www.geeksforgeeks.org/problems/sum-tree/1

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    SimpleEntry<Boolean, Integer> solve(Node root) {
        if (root == null)
            return new SimpleEntry<>(true, 0);

        if (root.left == null && root.right == null)
            return new SimpleEntry<>(true, root.data);

        int sum = 0;
        boolean b = true;

        if (root.left != null) {
            SimpleEntry<Boolean, Integer> cnt1 = solve(root.left);
            sum += cnt1.getValue();
            b = b && cnt1.getKey();
        }

        if (root.right != null) {
            SimpleEntry<Boolean, Integer> cnt1 = solve(root.right);
            sum += cnt1.getValue();
            b = b && cnt1.getKey();
        }

        if (sum != root.data)
            b = false;

        return new SimpleEntry<>(b, sum+root.data);
    }

    boolean isSumTree(Node root) {
        // Your code here

        return solve(root).getKey();
    }
}