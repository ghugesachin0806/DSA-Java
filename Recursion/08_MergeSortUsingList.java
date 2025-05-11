package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/sort-an-array/

class Solution {

    public void merge(List<Integer> list, int start, int mid, int end) {
        // startIndex is inclusive.
        // endIndex is exclusive.

        List<Integer> firstList = new ArrayList<>(list.subList(start, mid + 1));
        List<Integer> secondList =  new ArrayList<>(list.subList(mid + 1, end + 1));

        int firstIndex = 0;
        int secondIndex = 0;
        int index = start;

        while (firstIndex < firstList.size() && secondIndex < secondList.size()) {
            if (firstList.get(firstIndex).compareTo(secondList.get(secondIndex)) <= 0) {
                list.set(index++, firstList.get(firstIndex++));
            } else {
                list.set(index++, secondList.get(secondIndex++));
            }
        }

        if (firstIndex == firstList.size()) {
            for (int i = secondIndex; i < secondList.size(); i++) {
                list.set(index++, secondList.get(secondIndex++));
            }
        } else {
            for (int i = firstIndex; i < firstList.size(); i++) {
                list.set(index++, firstList.get(firstIndex++));
            }
        }

    }

    public void mergeSort(List<Integer> list, int start, int end) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(list, start, mid);
        mergeSort(list, mid + 1, end);

        merge(list, start, mid, end);
    }

    public int[] sortArray(int[] nums) {

        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        mergeSort(list, 0, list.size() - 1);

        nums = list.stream().mapToInt(i -> i).toArray();

        return nums;
    }
}
