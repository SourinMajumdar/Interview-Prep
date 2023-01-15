// Link: https://leetcode.com/problems/increment-submatrices-by-one/description/

// weekly 328, 15 Jan 2023
// Q2

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] a = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0], r2 = q[2];   // row1, row2
            int c1 = q[1], c2 = q[3];   // col1, col2
            // iterate over the matrix
            // with corners row1, col1 and row2, col2
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    a[i][j]++;  // increment
                }
            }
        }

        return a;   // return the matrix
    }
}

// TC: O(m * n^2), SC: O(n^2)


class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] a = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0], r2 = q[2];
            int c1 = q[1], c2 = q[3];
            for (int i = r1; i <= r2; i++) {
                a[i][c1]++;
            }
            if (c2 + 1 < n) {
                for (int i = r1; i <= r2; i++) {
                    a[i][c2 + 1]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] += a[i][j - 1];
            }
        }

        return a;
    }
}

// TC: O(m * n) + O(n ^ 2), SC: O(n ^ 2)