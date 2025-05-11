package Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/

class Solution {

    public void solve(int[] nums, int index, List<Integer> list, List<List<Integer>> glist) {
        if (index == nums.length) {
            glist.add(list);
            return;
        }

        // exclude call
        solve(nums, index + 1, list, glist);

        // include call
        List<Integer> newList = new ArrayList<>(list);
        newList.add(nums[index]);
        solve(nums, index + 1, newList, glist);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> glist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(nums, 0, list, glist);

        return glist;
    }
}
