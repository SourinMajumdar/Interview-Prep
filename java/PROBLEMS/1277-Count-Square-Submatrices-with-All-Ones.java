// Link: https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += (dp[0][i] = matrix[0][i]);
        }
        for (int i = 0; i < m; i++) {
            total += (dp[i][0] = matrix[i][0]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                total += dp[i][j];
            }
        }

        return total - dp[0][0];
    }
}

// TC: O(n + m) + O(m * n) ~ O(m * n)
// SC: O(m * n)