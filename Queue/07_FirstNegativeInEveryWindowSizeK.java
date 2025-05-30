package Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (arr[i] < 0)
                deque.add(i);
        }

        if (deque.isEmpty())
            list.add(0);
        else
            list.add(arr[deque.peek()]);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < 0)
                deque.add(i);

            if (!deque.isEmpty() && i - deque.peek() >= k)
                deque.removeFirst();

            if (deque.isEmpty())
                list.add(0);
            else
                list.add(arr[deque.peek()]);

        }

        return list;
    }
}
