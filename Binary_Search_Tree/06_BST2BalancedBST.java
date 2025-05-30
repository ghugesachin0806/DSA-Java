package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/balance-a-binary-search-tree/description/

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

    public void bstToList(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;

        if (root.left != null)
            bstToList(root.left, list);

        list.add(root);

        if (root.right != null)
            bstToList(root.right, list);

        root.left = null;
        root.right = null;
    }

    public TreeNode ListToBalancedBST(List<TreeNode> list, int start, int end) {

        if (start > end)
            return null;

        if (start == end)
            return list.get(start);

        int mid = start + (end - start) / 2;

        list.get(mid).left = ListToBalancedBST(list, start, mid - 1);
        list.get(mid).right = ListToBalancedBST(list, mid + 1, end);

        return list.get(mid);
    }

    public TreeNode balanceBST(TreeNode root) {

        // Inorder list
        List<TreeNode> list = new ArrayList<>();
        bstToList(root, list);

        return ListToBalancedBST(list, 0, list.size() - 1);
    }
}