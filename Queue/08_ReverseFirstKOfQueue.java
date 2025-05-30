package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {

        if (q.size() < k)
            return q;

        int tempK = k;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (tempK-- != 0) {
            stack.push(q.peek());
            q.remove();
        }

        while (!stack.isEmpty()) {
            q.add(stack.peek());
            stack.pop();
        }

        int n = q.size();
        int temp = n - k;

        while (temp-- != 0) {
            q.add(q.peek());
            q.remove();
        }

        return q;
    }
}