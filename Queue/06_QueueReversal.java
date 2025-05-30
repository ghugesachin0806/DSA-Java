package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/queue-reversal/1

class Solution {
    // Function to reverse the queue.
    public Queue<Integer> reverseQueue(Queue<Integer> queue) {
        // code here.

        ArrayDeque<Integer> st = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            st.push(queue.peek());
            queue.remove();
        }

        while (!st.isEmpty()) {
            queue.add(st.peek());
            st.pop();
        }

        return queue;

    }
}
