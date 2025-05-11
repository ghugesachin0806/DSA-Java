package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/permutations/

class Solution {

    public void solve(List<Integer> list, int index, List<List<Integer>> glist) {
        if (index == list.size()) {
            List<Integer> newList = new ArrayList<>(list);
            glist.add(newList);
            return;
        }

        for (int i = index; i < list.size(); i++) {
            // swap
            Collections.swap(list, index, i);
            // increase index in recursive call
            solve(list, index + 1, glist);
            // swap for previous state
            Collections.swap(list, index, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> glist = new ArrayList<>();
        solve(list, 0, glist);

        return glist;
    }
}
