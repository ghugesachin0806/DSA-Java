package Binary_Tree;

// https://www.naukri.com/code360/problems/count-leaf-nodes_893055

class BinaryTreeNode<T> {
  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;

  public BinaryTreeNode(T data) {
    this.data = data;
  }
}

class CountLeafNodes {

  public static int solve(BinaryTreeNode<Integer> root) {
    if (root == null)
      return 0;

    if (root.left == null && root.right == null)
      return 1;

    return solve(root.left) + solve(root.right);
  }

  public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
    // Write your code here.
    return solve(root);
  }
}
