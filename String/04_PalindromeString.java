package String;

// https://www.geeksforgeeks.org/problems/palindrome-string0817/1

class Solution {
    boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}