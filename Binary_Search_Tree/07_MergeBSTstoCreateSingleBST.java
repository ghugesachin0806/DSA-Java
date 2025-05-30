package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public void treesToPriorityQueue(TreeNode root, PriorityQueue<TreeNode> pq) {
        if (root == null)
            return;

        if (root.left != null)
            treesToPriorityQueue(root.left, pq);

        pq.add(root);

        if (root.right != null)
            treesToPriorityQueue(root.right, pq);

        root.left = null;
        root.right = null;
    }

    public TreeNode listToBalancedTree(List<TreeNode> list, int start, int end) {
        if (start > end)
            return null;

        if (start == end)
            return list.get(start);

        int mid = start + (end - start) / 2;

        list.get(mid).left = listToBalancedTree(list, start, mid - 1);
        list.get(mid).right = listToBalancedTree(list, mid + 1, end);

        return list.get(mid);
    }

    public TreeNode canMerge(List<TreeNode> trees) {

        PriorityQueue<TreeNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < trees.size(); i++) {
            treesToPriorityQueue(trees.get(i), pq);
        }

        List<TreeNode> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            list.add(pq.peek());
            pq.remove();
        }

        return listToBalancedTree(list, 0, list.size() - 1);
    }
}