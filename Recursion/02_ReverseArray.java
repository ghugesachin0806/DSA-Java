package Recursion;

// https://leetcode.com/problems/reverse-string/

class Solution {

    public void solve(char[] s, int n) {
        if (n < 0)
            return;

        char temp = s[n];

        solve(s, n - 1);

        s[s.length - 1 - n] = temp;
    }

    public void reverseString(char[] s) {
        solve(s, s.length - 1);
    }
}
