package HashMap_HashSet;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/single-number/description/

class Solution {
    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else
                map.put(num, map.get(num) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1)
                return num;
        }

        return 0;
    }
}
