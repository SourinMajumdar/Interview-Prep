// Link: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column

// Biweekly 92, 26 Nov 2022
// Q2


class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] diff = new int[m][n];

        int[] zeroRows = new int[m];
        int[] zeroCols = new int[n];
        int[] oneRows = new int[m];
        int[] oneCols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneRows[i]++;
                    oneCols[j]++;
                }
                else {
                    zeroRows[i]++;
                    zeroCols[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = oneRows[i] + oneCols[j] - zeroRows[i] - zeroCols[j];
            }
        }

        return diff;
    }
}

// TC: O(m * n), SC: O(m + n)


class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] oneRows = new int[m];
        int[] oneCols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneRows[i]++;
                    oneCols[j]++;
                }
            }
        }

        int[][] diff = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // diff[i][j] = oneRows[i] + oneCols[j] - (m - oneRows[i]) - (n - oneCols[j]);
                diff[i][j] = 2 * (oneRows[i] + oneCols[j]) - m - n;
            }
        }

        return diff;
    }
}

// TC: O(m * n), SC: O(m + n)