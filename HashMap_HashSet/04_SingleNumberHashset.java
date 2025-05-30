package HashMap_HashSet;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/single-number/description/

class Solution {
    public int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int sum =0, sumSet =0;

        for(int num:nums)
        {
            sum+=num;
            if(!set.contains(num))
            {
                set.add(num);
                sumSet+=num;
            }
        }
        return 2*sumSet-sum;
    }
}