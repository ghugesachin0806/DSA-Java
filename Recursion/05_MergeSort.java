package Recursion;

import java.util.Arrays;

// https://leetcode.com/problems/sort-an-array/

class Solution {

    void merge(int[] nums, int start, int mid, int end) {
        // Arrays.copyOfRange(nums, start, mid + 1) because the end index in copyOfRange
        // is exclusive
        int[] firstArray = Arrays.copyOfRange(nums, start, mid + 1);
        int[] secondArray = Arrays.copyOfRange(nums, mid + 1, end + 1);

        int firstIndex = 0;
        int secondIndex = 0;

        int index = start;

        while (firstIndex != firstArray.length && secondIndex != secondArray.length) {
            if (firstArray[firstIndex] <= secondArray[secondIndex]) {
                nums[index++] = firstArray[firstIndex++];
            } else {
                nums[index++] = secondArray[secondIndex++];
            }
        }

        if (firstIndex != firstArray.length) {
            for (int i = firstIndex; i < firstArray.length; i++) {
                nums[index++] = firstArray[firstIndex++];
            }
        } else {
            for (int i = secondIndex; i < secondArray.length; i++) {
                nums[index++] = secondArray[secondIndex++];
            }
        }
    }

    void mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    public int[] sortArray(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }
}
