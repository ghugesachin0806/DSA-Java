package Stack;

import java.util.ArrayDeque;

// https://www.naukri.com/code360/problems/minimum-cost-to-make-string-valid_1115770

class Solution {
  public static int findMinimumCost(String str) {
    // Write your code here

    if (str.length() % 2 != 0)
      return -1;

    ArrayDeque<Character> st = new ArrayDeque<>();

    for (int i = 0; i < str.length(); i++) {
      if (st.isEmpty()) {
        st.push(str.charAt(i));
      } else {
        if (st.peek() == '{' && str.charAt(i) == '}')
          st.pop();
        else
          st.push(str.charAt(i));
      }
    }

    if (st.isEmpty())
      return 0;
    else {
      int left = 0;
      int right = 0;

      while (!st.isEmpty()) {
        if (st.peek() == '}')
          left++;
        else
          right++;

        st.pop();
      }

      int cnt = 0;

      cnt = (left + 1) / 2;
      cnt += (right + 1) / 2;

      return cnt;
    }

  }
}

// Hint - In valid parenthesis
// 1. {{{{...
// 2. }}}}...
// 3. ....}}}}{{...
