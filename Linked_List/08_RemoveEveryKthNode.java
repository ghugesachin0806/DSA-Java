package Linked_List;

// https://www.geeksforgeeks.org/problems/remove-every-kth-node/1

/* Link list Node */
class Node {
    Node next;
    int data;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    /* You are required to complete this method */
    Node deleteK(Node head, int k) {
        // Your code here
        if (k <= 1)
            return null;

        Node temp = head;
        Node prev = null;
        int cnt = 1;

        while (temp != null && temp.next != null) {
            cnt++;
            prev = temp;
            temp = temp.next;

            if (cnt == k) {
                prev.next = temp.next;
                temp.next = null;
                temp = prev.next;
                cnt = 1;
            }
        }

        return head;
    }
}
