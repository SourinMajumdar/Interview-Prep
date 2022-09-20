// Link: https://leetcode.com/problems/longest-common-subsequence/
// Solution: https://www.youtube.com/watch?v=0Ql40Llp09E

// iterating from the end
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {

                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}


// iterating from the start
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}


// TC: O(m * n), SC: O(m * n)