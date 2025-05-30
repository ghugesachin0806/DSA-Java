package Linked_List;

// https://www.geeksforgeeks.org/problems/print-linked-list-elements/1

/* Node is defined as */
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    // Function to display the elements of a linked list in same line
    void printList(Node head) {
        // add code here.
        Node temp = head;
        
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        return;
    }
}
