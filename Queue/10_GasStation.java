package Queue;

// https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1

class Solution {
    public int startStation(int[] gas, int[] cost) {
        // Your code here
        int balance = 0;
        int deficient = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            balance = balance + gas[i] - cost[i];

            if (balance < 0) {
                start = i + 1;
                deficient = deficient + balance;
                balance = 0;
            }
        }

        if (balance + deficient >= 0)
            return start;
        else
            return -1;
    }
}
