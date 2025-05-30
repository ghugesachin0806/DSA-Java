package Linked_List;

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

        ListNode tempHead = head;
        ListNode prev = null;
        ListNode temp = null;

        while (tempHead != null && tempHead.next != null) {
            temp = tempHead;
            tempHead = tempHead.next;
            temp.next = prev;
            prev = temp;
        }

        tempHead.next = prev;

        return tempHead;
    }
}