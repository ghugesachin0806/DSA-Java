package Recursion;

// https://leetcode.com/problems/sort-an-array/

class Solution {

    public int pivotWithPartition(int[] nums, int start, int end) {
        int count = 0;

        for (int i = start + 1; i <= end; i++) {
            if (nums[i] <= nums[start])
                count++;
        }

        if (count > 0) {
            // swap
            int temp = nums[start + count];
            nums[start + count] = nums[start];
            nums[start] = temp;
        }

        int i = start;
        int j = end;

        int pivotIndex = start + count;

        while (i < pivotIndex && j > pivotIndex) {
            while (nums[i] <= nums[pivotIndex]) {
                i++;
            }

            while (nums[j] > nums[pivotIndex]) {
                j--;
            }

            if (i < pivotIndex && j > pivotIndex) {
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        return start + count;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivot = pivotWithPartition(nums, start, end);

        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);

    }

    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}