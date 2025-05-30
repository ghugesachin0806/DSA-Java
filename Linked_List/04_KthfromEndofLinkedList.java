package Linked_List;

import java.util.ArrayDeque;

// https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1

/* Structure of node */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {

        int cnt = 0;

        ArrayDeque<Node> st = new ArrayDeque<>();

        Node temp = head;

        while (temp != null) {
            st.push(temp);
            temp = temp.next;
            cnt++;
        }

        if (cnt < k)
            return -1;

        while (k-- != 0) {
            temp = st.peek();
            st.pop();
        }

        return temp.data;
    }
}