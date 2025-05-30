package Stack;

import java.util.ArrayDeque;

// https://leetcode.com/problems/reverse-string/

class Solution {
    public void reverseString(char[] s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        int cnt = 0;

        while (!stack.isEmpty()) {
            s[cnt++] = stack.peek();
            stack.pop();
        }
    }
}