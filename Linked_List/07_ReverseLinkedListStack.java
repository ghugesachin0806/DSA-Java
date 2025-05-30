package Linked_List;

import java.util.ArrayDeque;

// https://leetcode.com/problems/reverse-linked-list/description/

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode reverseList(ListNode head) {

        if (head == null)
            return head;

        ArrayDeque<ListNode> st = new ArrayDeque<>();

        ListNode temp = head;

        while (temp != null) {
            st.push(temp);
            temp = temp.next;
        }

        ListNode tempHead = st.peek();

        while (!st.isEmpty()) {
            temp = st.peek();
            st.pop();
            if (!st.isEmpty())
                temp.next = st.peek();
            else
                temp.next = null;
        }

        return tempHead;
    }
}