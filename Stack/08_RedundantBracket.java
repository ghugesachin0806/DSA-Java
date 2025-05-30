package Stack;

import java.util.ArrayDeque;

// https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1

class Solution {
    public static int checkRedundancy(String s) {
        // code here

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*'
                    || s.charAt(i) == '/') {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (stack.peek() == '(')
                        return 1;

                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }

        return 0;
    }
}

// Hint -
// There should be any operator in between parenthesis, to be parenthesis valid