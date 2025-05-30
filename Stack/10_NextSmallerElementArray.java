package Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

// https://www.naukri.com/code360/problems/next-smaller-element_1112581

class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        // Write your code here.

        ArrayDeque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> art = new ArrayList<>();

        st.push(-1);

        for (int i = arr.size() - 1; i >= 0; i--) {

            while (!st.isEmpty()) {
                if (arr.get(i) > st.peek()) {
                    art.add(st.peek());
                    st.push(arr.get(i));
                    break;
                } else
                    st.pop();
            }
        }

        Collections.reverse(art);

        return art;
    }
}
