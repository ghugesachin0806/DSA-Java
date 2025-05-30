package Queue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1

class Solution {
    public String FirstNonRepeating(String s) {
        // code here

        StringBuilder str = new StringBuilder();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
                queue.add(s.charAt(i));
            }

            while (!queue.isEmpty() && map.get(queue.peek()) != 1) {
                queue.remove();
            }

            if (!queue.isEmpty())
                str.append(queue.peek());
            else
                str.append('#');
        }

        return str.toString();
    }
}
