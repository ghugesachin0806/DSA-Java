package Linked_List;

// https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/1

class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}

class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        // code here
        
        Node temp = head;
        
        int cnt=0;
        
        while(temp!=null)
        {
            cnt++;
            temp = temp.next;
        }
        
        return cnt;
    }
}