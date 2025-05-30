package Binary_Search_Tree;

// https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class Tree {

    public static int maxNode(Node root) {
        if (root == null)
            return 0;

        if (root.right == null)
            return root.data;

        return maxNode(root.right);
    }

    public static Node solve(Node root, int x) {
        if (root == null)
            return root;

        if (root.data == x) {
            // 0 child
            if (root.left == null && root.right == null)
                return null;
            // only left or right child
            if (root.left == null || root.right == null) {
                if (root.left == null)
                    return root.right;
                else
                    return root.left;
            }
            // both child
            int temp = maxNode(root.left);
            root.data = temp;
            root.left = solve(root.left, temp);

            return root;
        }

        root.left = solve(root.left, x);
        root.right = solve(root.right, x);

        return root;

    }

    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int X) {
        // code here.
        return solve(root, X);
    }
}

// There are four cases for deletion of node
// 1. Node doesn't have any child
// 2. Node has left child
// 3. Node has right child
// 4. Node have both left and right childs

// for 2 child case, you can do the following
// 1. just go to right and find min and swap with current node.
// 2. just go to left and find max and swap with current node.