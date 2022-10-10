// Link: https://leetcode.com/problems/break-a-palindrome/
// Solution: https://www.youtube.com/watch?v=0DSALG_D8-Ihttps://www.youtube.com/watch?v=0DSALG_D8-I


class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";

        char[] strArr = palindrome.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            if (strArr[i] != 'a') {
                strArr[i] = 'a';
                return new String(strArr); // or String.valueOf(strArr)
            }
        }

        strArr[n - 1] = 'b';
        return new String(strArr);
    }
}

// TC: O(n), SC: O(n)