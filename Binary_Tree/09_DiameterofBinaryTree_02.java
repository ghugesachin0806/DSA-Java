package Binary_Tree;

import java.util.AbstractMap.SimpleEntry;

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

    // SimpleEntry<Diameter,height> 
    SimpleEntry<Integer,Integer> solve(Node root)
    {
        if(root==null)
        {
            return new SimpleEntry<>(0,0);
        }

        SimpleEntry<Integer,Integer> left = solve(root.left);
        SimpleEntry<Integer,Integer> right = solve(root.right);

        int diameterThroughRoot = left.getValue() + right.getValue(); 
        int Maxdiameter = Math.max(left.getKey(),Math.max(right.getKey(), diameterThroughRoot));
        int maxHeight = Math.max(left.getValue(), right.getValue())+1;

        return new SimpleEntry<>(Maxdiameter,maxHeight);
    }
    int diameter(Node root) {
        // Your code here
        SimpleEntry<Integer,Integer> pair = solve(root);
        return pair.getKey();
    }
}
