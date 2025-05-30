import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    public static void printBSTInorder(Node root) {

        if (root == null)
            return;

        printBSTInorder(root.left);
        System.out.print(root.data + " ");
        printBSTInorder(root.right);
    }

    public static Node insertElementIntoNode(int element, Node root) {
        if (root == null)
            return new Node(element);

        if (root.data > element)
            root.left = insertElementIntoNode(element, root.left);
        else
            root.right = insertElementIntoNode(element, root.right);

        return root;
    }

    public static void main(String[] args) {

        System.out.print("Enter Number of elements : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter " + n + " elements : ");
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            arr[i] = k;
        }

        Node root = null;
        for (int i = 0; i < n; i++)
            root = insertElementIntoNode(arr[i], root);

        System.out.print("\nBST Inorder is : ");
        printBSTInorder(root);

    }
}

// Enter Number of elements : 10
// Enter 10 elements : 42 17 8 23 56 3 91 12 30 7
// BST Inorder is : 3 7 8 12 17 23 30 42 56 91