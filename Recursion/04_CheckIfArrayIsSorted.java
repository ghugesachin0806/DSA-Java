package Recursion;

// https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1

class Solution {

    boolean solve(int[] arr, int n) {
        if (n == 0)
            return true;

        boolean b1 = solve(arr, n - 1);

        if (arr[n] >= arr[n - 1])
            return b1 && true;
        else
            return false;
    }

    public boolean arraySortedOrNot(int[] arr) {
        // code here
        return solve(arr, arr.length - 1);
    }
}