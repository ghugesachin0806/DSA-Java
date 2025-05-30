package HashMap_HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-arrays/description/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;

        Set<Integer> set = new HashSet<>();

        while (p1 != nums1.length && p2 != nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                set.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] > nums2[p2])
                p2++;
            else
                p1++;
        }

        // Use toArray to get Integer[] and then convert to int[]
        Integer[] temp = set.toArray(new Integer[0]);
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i];
        }

        return result;

    }
}
