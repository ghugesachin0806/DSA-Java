package Recursion;

import java.util.ArrayList;

// https://www.codingninjas.com/codestudio/problems/subsequences-of-string_985087

class Solution {

    public static void solve(String mainStr, int index, String str, ArrayList<String> ArrayList) {
        if (index == mainStr.length()) {
            if (!str.isEmpty())
                ArrayList.add(str);
            return;
        }

        // exclude call
        solve(mainStr, index + 1, str, ArrayList);

        // include call
        String newStr = new String(str) + mainStr.charAt(index);
        solve(mainStr, index + 1, newStr, ArrayList);

    }

    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        solve(str, 0, new String(), arrayList);

        return arrayList;
    }
}