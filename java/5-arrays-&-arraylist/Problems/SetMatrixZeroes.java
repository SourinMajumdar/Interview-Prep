// Problem: https://leetcode.com/problems/set-matrix-zeroes/
// Solution: https://www.youtube.com/watch?v=HliRLQ_A81o

// Brute force approach - TC: O(m * n), SC: O(m + n)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < row.size(); i++) {
            for (int j = 0; j < n; j++) {
                matrix[row.get(i)][j] = 0;
            }
        }

        for (int i = 0; i < col.size(); i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][col.get(i)] = 0;
            }
        }
    }
}
