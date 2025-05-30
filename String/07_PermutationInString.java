package String;

import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/description/

class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        int[] freq = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq, window))
            return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++; // Add new char
            window[s2.charAt(i - s1.length()) - 'a']--; // Remove leftmost char

            if (Arrays.equals(freq, window))
                return true;
        }

        return false;
    }
}