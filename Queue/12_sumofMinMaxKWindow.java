package Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/

class Solution {
    public List<Integer> sumofMinMaxKWindow(int[] arr, int k) {

        List<Integer> list = new ArrayList<>();

        Deque<Integer> maxi = new ArrayDeque<>();
        Deque<Integer> mini = new ArrayDeque<>();

        // for the first window
        for (int i = 0; i < k; i++) {

            while (!mini.isEmpty() && arr[mini.getLast()] > arr[i]) {
                mini.removeLast();
            }
            mini.addLast(i);

            while (!maxi.isEmpty() && arr[maxi.getLast()] < arr[i]) {
                maxi.removeLast();
            }
            maxi.addLast(i);
        }
        list.add(arr[mini.getFirst()] + arr[maxi.getFirst()]);
        // for the remaining window

        for (int i = k; i < arr.length; i++) {
            // addition
            while (!mini.isEmpty() && arr[mini.getLast()] > arr[i]) {
                mini.removeLast();
            }
            mini.addLast(i);

            while (!maxi.isEmpty() && arr[maxi.getLast()] < arr[i]) {
                maxi.removeLast();
            }
            maxi.addLast(i);

            // removal out of window element
            while (!mini.isEmpty() && i - mini.getFirst() >= k) {
                mini.removeFirst();
            }

            while (!maxi.isEmpty() && i - maxi.getFirst() >= k) {
                maxi.removeFirst();
            }

            list.add(arr[mini.getFirst()] + arr[maxi.getFirst()]);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        List<Integer> result = sol.sumofMinMaxKWindow(arr, k);

        System.out.println("Sum of min and max in each window of size " + k + ":");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}