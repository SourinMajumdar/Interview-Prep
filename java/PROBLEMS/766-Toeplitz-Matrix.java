// Link: https://leetcode.com/problems/toeplitz-matrix/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}

// TC: O(m * n), SC: O(1)