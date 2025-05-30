package String;

// https://leetcode.com/problems/valid-palindrome/description/

class Solution {

    public boolean isAlphaNumeric(char ch) {
        // a-z , A-Z , 0-9 are aplha-numeric
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
            return true;
        else
            return false;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (isAlphaNumeric(s.charAt(i)) && isAlphaNumeric(s.charAt(j))) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else
                    return false;
            } else if (isAlphaNumeric(s.charAt(i))) {
                j--;
            } else {
                i++;
            }
        }

        return true;
    }
}
