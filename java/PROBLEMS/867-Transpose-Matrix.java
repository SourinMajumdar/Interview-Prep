// Problem link: https://leetcode.com/problems/transpose-matrix/
// Solution link: https://www.youtube.com/watch?v=fsyfnJ3tzZs

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = matrix[j][i];
            }
        }

        return ans;
    }
}

// TC: O(m * n), SC: O(m * n)