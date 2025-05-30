package Stack;

import java.util.ArrayDeque;

// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

class Solution {
    public int celebrity(int mat[][]) {
        // code here

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < mat.length; i++) {
            st.push(i);
        }

        while (!st.isEmpty() && st.size() != 1) {
            int a = st.peek();
            st.pop();
            int b = st.peek();
            st.pop();

            if (mat[a][b] == 0 && mat[b][a] == 1)
                st.push(a);

            if (mat[b][a] == 0 && mat[a][b] == 1)
                st.push(b);
        }

        if (st.isEmpty())
            return -1;

        for (int i = 0; i < mat.length; i++) {
            if (st.peek() == i)
                continue;

            if (mat[st.peek()][i] == 0 && mat[i][st.peek()] == 1)
                continue;
            else
                return -1;
        }

        return st.peek();
    }
}
