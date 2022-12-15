// Link: https://leetcode.com/problems/palindromic-substrings/description/
// https://www.youtube.com/watch?v=XmSOWnL6T_I


class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) dp[i][j] = true;
                else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j]) count++;
            }
        }

        return count;
    }
}

// TC: O(n^2 / 2) ~ O(n^2)
// SC: O(n^2)