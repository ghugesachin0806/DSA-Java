package Recursion;

// https://leetcode.com/problems/fibonacci-number/description/

class Solution {
    public int solve(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return solve(n - 1) + solve(n - 2);
    }

    public int fib(int n) {
        return solve(n);
    }
}