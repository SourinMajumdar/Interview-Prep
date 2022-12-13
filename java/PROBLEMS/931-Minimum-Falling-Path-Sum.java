// Link: https://leetcode.com/problems/minimum-falling-path-sum/description/
// https://www.youtube.com/watch?v=N_aJ5qQbYA0


class Solution {
    private int IMIN = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0] = matrix[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int ld = (j > 0)? matrix[i][j] + dp[i - 1][j - 1] : IMIN;
                int rd = (j < n - 1)? matrix[i][j] + dp[i - 1][j + 1] : IMIN;
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }

        int min = IMIN;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }
}

// TC: O(n ^ 2) + O(n) ~ O(n ^ 2)
// SC: O(n ^ 2)


class Solution {
    private int IMIN = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + matrix[i - 1][j];
                int ld = (j > 0)? matrix[i][j] + matrix[i - 1][j - 1] : IMIN;
                int rd = (j < n - 1)? matrix[i][j] + matrix[i - 1][j + 1] : IMIN;
                matrix[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }

        int min = IMIN;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[n - 1][i]);
        }

        return min;
    }
}

// TC: O(n ^ 2) + O(n) ~ O(n ^ 2)
// SC: O(1)