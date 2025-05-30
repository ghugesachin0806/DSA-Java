package Stack;

import java.util.ArrayDeque;

// https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1

class Solution {

    public static int precedence(char ch) {
        if (ch == '^')
            return 3;
        else if (ch == '/' || ch == '*')
            return 2;
        else if (ch == '+' || ch == '-')
            return 1;
        else
            return 0;
    }

    public static String infixToPostfix(String s) {

        StringBuilder res = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                res.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }

                if (!stack.isEmpty())
                    stack.pop();
            } else {
                while (!stack.isEmpty() && (precedence(stack.peek()) >= precedence(s.charAt(i)))) {
                    res.append(stack.pop());
                }
                stack.push(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {

            if (stack.peek() != '(')
                res.append(stack.pop());
            else
                stack.pop();
        }

        return new String(res);
    }
}