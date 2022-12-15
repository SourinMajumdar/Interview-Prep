// Link: https://leetcode.com/problems/longest-palindromic-substring/description/

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int l = -1, r = -1, maxLen = 0;

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) dp[i][j] = true;
                else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    l = i;
                    r = j;
                }
            }
        }

        return s.substring(l, r + 1);
    }
}

// TC: O(n^2 / 2) + O(n) ~ O(n ^ 2)
// SC: O(n ^ 2)