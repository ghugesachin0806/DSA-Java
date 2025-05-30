package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/problems/level-order-traversal/1

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    // level order trversal
    public void levelOrderTraversal(Node root, ArrayList<ArrayList<Integer>> arrayList) {
        if (root == null)
            return;

        // queue
        // ArrayDeque<Node> queue = new ArrayDeque<>(); // doesn't allow null value
        LinkedList<Node> queue = new LinkedList<>();

        // list
        ArrayList<Integer> list = new ArrayList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();

            if (temp == null) {

                ArrayList<Integer> tempList = new ArrayList<>(list);
                arrayList.add(tempList);
                list.clear();

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {

                list.add(temp.data);

                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }

    }

    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        levelOrderTraversal(root, arrayList);

        return arrayList;
    }
}