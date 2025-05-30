package Linked_List;

// https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1

//   Node is defined as
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here

        Node head = null;
        Node temp = null;
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {

            if (temp1.data <= temp2.data) {
                if (head == null) {
                    head = head1;
                    temp1 = head1;
                    temp = head;
                } else {
                    Node kk = temp1;
                    temp1 = temp1.next;
                    kk.next = null;
                    temp.next = kk;
                    temp = temp.next;
                }
            } else {
                if (head == null) {
                    head = head2;
                    temp2 = head2;
                    temp = head;
                } else {
                    Node kk = temp2;
                    temp2 = temp2.next;
                    kk.next = null;
                    temp.next = kk;
                    temp = temp.next;
                }
            }
        }

        if (temp1 != null) {
            if (head == null) {
                head = temp1;
                temp = temp1;
            } else
                temp.next = temp1;
        } else {
            if (head == null) {
                head = temp2;
                temp = temp2;
            } else
                temp.next = temp2;
        }
        return head;
    }
}
