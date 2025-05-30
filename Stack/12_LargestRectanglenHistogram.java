package Stack;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/

class Solution {
    public int largestRectangleArea(int[] heights) {

        ArrayDeque<Map.Entry<Integer, Integer>> st = new ArrayDeque<>();

        ArrayList<Integer> frontList = new ArrayList<>();
        ArrayList<Integer> backList = new ArrayList<>();

        // front
        st.push(new AbstractMap.SimpleEntry<>(-1, heights.length));
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty()) {
                if (st.peek().getKey() < heights[i]) {
                    int indexDiff = st.peek().getValue() - 1;
                    frontList.add(indexDiff - i);
                    st.push(new AbstractMap.SimpleEntry<>(heights[i], i));
                    break;
                } else
                    st.pop();
            }
        }
        Collections.reverse(frontList);

        // back
        st.clear();
        st.push(new AbstractMap.SimpleEntry<>(-1, -1));
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty()) {
                if (st.peek().getKey() < heights[i]) {
                    int indexDiff = st.peek().getValue() + 1;
                    backList.add(i - indexDiff);
                    st.push(new AbstractMap.SimpleEntry<>(heights[i], i));
                    break;
                } else
                    st.poll();
            }
        }

        ArrayList<Integer> breadth = new ArrayList<>();
        for (int i = 0; i < backList.size(); i++) {
            breadth.add(frontList.get(i) + backList.get(i) + 1);
        }

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < breadth.size(); i++) {
            int temp = heights[i] * breadth.get(i);

            if (temp > maxArea)
                maxArea = temp;
        }

        return maxArea;
    }
}