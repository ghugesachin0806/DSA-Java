package Stack;

import java.util.ArrayDeque;

// https://leetcode.com/problems/valid-parentheses/description/

class Solution {
    public boolean isValid(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else {
                char top = stack.peek();

                if ((top == '(' && s.charAt(i) == ')') || (top == '[' && s.charAt(i) == ']')
                        || (top == '{' && s.charAt(i) == '}'))
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }

        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}