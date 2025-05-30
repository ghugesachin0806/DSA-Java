package Stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/sort-a-stack/1

class GfG {

    public void sort(Stack<Integer> s, int k) {
        if (s.empty() || k >= s.peek()) {
            s.push(k);
            return;
        }

        int temp = s.peek();
        s.pop();

        sort(s, k);
        s.push(temp);

    }

    public void solve(Stack<Integer> s) {
        if (s.empty())
            return;

        int k = s.peek();
        s.pop();

        solve(s);

        sort(s, k);
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        solve(s);
        return s;
    }
}