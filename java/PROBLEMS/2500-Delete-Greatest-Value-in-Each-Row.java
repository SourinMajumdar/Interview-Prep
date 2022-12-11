// Link: https://leetcode.com/problems/delete-greatest-value-in-each-row/description/

// weekly 323, 11 dec 2022
// Q1


class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int sum = 0;

        for (int[] row : grid) {
            Arrays.sort(row);
        }

        for (int i = grid[0].length - 1; i >= 0; i--) {
            int max = 0;

            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
                // grid[j][i] = 0;
            }

            sum += max;
        }

        return sum;
    }
}

// TC: O(m * n * logn) + O(n * m)
// SC: O(1)