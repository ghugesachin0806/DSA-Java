package Linked_List;

// https://www.geeksforgeeks.org/problems/circular-linked-list-traversal/1

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

}

class Solution {
    /* Function to print nodes in a given Circular linked list */
    void printList(Node head) {
        // Your code here
        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

    }
}
