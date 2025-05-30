package Stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/reverse-a-stack/1

class Solution {

    static void insertAtBottom(Stack<Integer> s, int k) {
        if (s.empty()) {
            s.push(k);
            return;
        }

        int temp = s.peek();
        s.pop();

        insertAtBottom(s, k);

        s.push(temp);
    }

    static void solve(Stack<Integer> s) {

        if (s.empty())
            return;

        int temp = s.peek();

        s.pop();

        solve(s);

        insertAtBottom(s, temp);
    }

    static void reverse(Stack<Integer> s) {
        // add your code here
        solve(s);
    }
}