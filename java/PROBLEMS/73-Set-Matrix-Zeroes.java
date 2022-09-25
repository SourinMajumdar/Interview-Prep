// Problem: https://leetcode.com/problems/set-matrix-zeroes/
// (Programmer's Zone) https://www.youtube.com/watch?v=HliRLQ_A81o
// (Striver) https://www.youtube.com/watch?v=M65xBewcqcI&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=11


// Absolute Brute force approach:

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // We create a 2D boolean array
        boolean[][] setZero = new boolean[m][n];

        // for every index in matrix where we need to put zero
        // we put a true in those same indices in boolean array

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {

                    // we set the whole row to true in boolean array
                    for (int row = 0; row < m; row++) {
                        if (matrix[row][j] != 0) {
                            setZero[row][j] = true;
                        }
                    }

                    // we set the whole column to true in boolean array
                    for (int col = 0; col < n; col++) {
                        if (matrix[i][col] != 0) {
                            setZero[i][col] = true;
                        }
                    }

                    // setting true in whole column or row means nothing but
                    // putting true in every index in that row or column
                }
            }
        }

        // we iterate over matrix again
        // if we find a true in that same index of boolean array
        // we put a 0 in that very index of matrix array

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (setZero[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// TC: O((m * n) * (m + n)) + O(m * n) => O((m * n) * (m + n))
// SC: O(m * n)




// A little optimization to above the brute force:
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        List<Integer> rows = new ArrayList<>();     // indices of rows to be set to zeroes
        List<Integer> cols = new ArrayList<>();     // indices of columns to be set to zeroes

        // we record the rows and columns that we need to put zeroes at
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Transforming rows:
        // we keep a particular row constant and move to each column in that row and put 0
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < n; j++) {
                matrix[rows.get(i)][j] = 0;
            }
        }

        // Transforming columns:
        // we keep a particular column constant and move to each row in that column and put 0
        for (int i = 0; i < cols.size(); i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][cols.get(i)] = 0;
            }
        }
    }
}

// TC: O(m * n) * 3 => (m * n)
// SC: O(m) + O(n)


// a little runtime complexity optimization to the above approach:
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();     // indices of rows to be set to zeroes
        Set<Integer> cols = new HashSet<>();     // indices of columns to be set to zeroes

        // we record the rows and columns that we need to make zeroes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // if any of i or j in the index pair (i, j) is present in the sets
        // it means that row i or column j (whichever is present) needs to be set to 0s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// TC: O(m * n) + O(m * n) => O(m * n)
// SC: O(m) + O(n)



// Space optimized solution:
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col0 = false;
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = true;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (col0) matrix[i][0] = 0;
        }
    }
}

// TC: O(m * n) + O(m * n) => O(m * n)
// SC: O(1)