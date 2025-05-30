package Binary_Tree;

import java.util.AbstractMap.SimpleEntry;

// https://www.geeksforgeeks.org/problems/check-for-balanced-tree/1

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {

    SimpleEntry<Boolean, Integer> solve(Node root) {
        if (root == null) {
            return new SimpleEntry<>(true, 0);
        }

        SimpleEntry<Boolean, Integer> cnt1 = solve(root.left);
        SimpleEntry<Boolean, Integer> cnt2 = solve(root.right);

        boolean b1 = Math.abs(cnt1.getValue() - cnt2.getValue()) <= 1 ? true : false;
        b1 = b1 && cnt1.getKey() && cnt2.getKey();

        return new SimpleEntry<>(b1, Math.max(cnt1.getValue(), cnt2.getValue()) + 1);
    }

    public boolean isBalanced(Node root) {
        // code here
        SimpleEntry<Boolean, Integer> pair = solve(root);

        return pair.getKey();
    }
}
