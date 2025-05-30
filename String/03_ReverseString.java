package String;

// https://leetcode.com/problems/reverse-string/description/

class Solution {

    public void solve(char[] s, int index) {
        if (index == s.length)
            return;

        char temp = s[index];
        solve(s, index + 1);
        s[s.length - index - 1] = temp;
    }

    public void reverseString(char[] s) {
        solve(s, 0);
    }
}
