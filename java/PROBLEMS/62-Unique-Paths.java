// Link: https://leetcode.com/problems/unique-paths/?envType=study-plan&id=level-1
// Solution: https://www.youtube.com/watch?v=6qMFjFC9YSc


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // We first fill the 0-th row and 0-th column with 1s
        // because there is only 1 way we can reach each of them

        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

// TC: O(m + n) + O(m * n) => O(m * n)
// SC: O(m * n)