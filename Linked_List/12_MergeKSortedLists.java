package Linked_List;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/description/

//  Definition for singly-linked list.
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val)); // max-heap


        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];

            while (temp != null) {
                pq.add(temp);
                temp = temp.next;
            }
        }

        ListNode head = null;
        ListNode temp = null;

        while (!pq.isEmpty()) {

            if (head == null) {
                head = pq.peek();
                temp = head;
                pq.remove();
                continue;
            }
            temp.next = pq.peek();
            pq.remove();
            temp = temp.next;
        }

        if (temp != null)
            temp.next = null;

        return head;
    }
}
