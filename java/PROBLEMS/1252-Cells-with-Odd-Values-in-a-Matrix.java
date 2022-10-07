// Link: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];

        for (int[] i : indices) {
            incrementRow(mat, i[0]);
            incrementCol(mat, i[1]);
        }

        int count = 0;

        for (int[] row : mat) {
            for (int i : row) {
                if (i % 2 == 1) count++;
            }
        }

        return count;
    }

    public void incrementRow(int[][] mat, int r) {
        for (int i = 0; i < mat[0].length; i++) {
            mat[r][i]++;
        }
    }

    public void incrementCol(int[][] mat, int c) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][c]++;
        }
    }
}

// TC: O(indices.length * (m + n)) + O(m * n)
// SC: O(m * n)