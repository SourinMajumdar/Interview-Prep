// Link: https://leetcode.com/problems/range-sum-query-2d-immutable/

class NumMatrix {
    private int[][] mat;

    public NumMatrix(int[][] matrix) {
        this.mat = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += mat[i][j];
            }
        }

        return sum;
    }
}

// TC: O(k * m * n), SC: O(m * n)
// let k be the number of calls made to sumRegion()



class NumMatrix {
    private int[][] A;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        this.A = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                A[i][j] = A[i - 1][j] + A[i][j - 1] - A[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return A[row2 + 1][col2 + 1] + A[row1][col1] - A[row1][col2 + 1] - A[row2 + 1][col1];
    }
}

// TC: O(m * n), SC: O(m * n)
// sumRegion runs on O(1) time complexity