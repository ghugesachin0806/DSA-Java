package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

// https://www.naukri.com/code360/problems/interleave-the-first-half-of-the-queue-with-the-second-half_1169450

class Solution {
    public static void interLeaveQueue(Queue<Integer> q) {
        // Write your code here.

        int size = q.size() / 2;
        ArrayDeque<Integer> st = new ArrayDeque<>();

        int temp = size;

        while (temp-- != 0) {
            st.push(q.peek());
            q.remove();
        }

        temp = size;

        while (temp-- != 0) {
            q.add(st.peek());
            st.pop();
        }

        temp = size;

        while (temp-- != 0) {
            q.add(q.peek());
            q.remove();
        }

        temp = size;

        while (temp-- != 0) {
            st.push(q.peek());
            q.remove();
        }

        while (!st.isEmpty()) {
            q.add(st.peek());
            st.pop();
            q.add(q.peek());
            q.remove();
        }
    }
}