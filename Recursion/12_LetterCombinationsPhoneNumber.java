package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class Solution {

    void solve(StringBuilder digits, int index, StringBuilder str, List<String> list, List<String> input) {
        if (index == digits.length()) {
            String newStr = new String(str);
            if (newStr.length() > 0)
                list.add(newStr);
            return;
        }

        char c = digits.charAt(index);

        int k = c - '0';

        for (int i = 0; i < input.get(k).length(); i++) {
            str.append(input.get(k).charAt(i));

            solve(digits, index + 1, str, list, input);

            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> input = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

        StringBuilder digitBuilder = new StringBuilder(digits);

        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        solve(digitBuilder, 0, str, list, input);

        return list;
    }
}
