// Link: https://leetcode.com/problems/maximum-sum-of-an-hourglass/

// Weekly 313, 2 Oct 2022
// Q2

class Solution {
    public int maxSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                int currSum =
                        grid[i][j] + grid[i][j + 1] + grid[i][j + 2] +              // top of the hourglass
                        grid[i + 1][j + 1] +                                        // middle of the hourglass
                        grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];   // base of the hourglass

                maxSum = Math.max(currSum, maxSum);
            }
        }

        return maxSum;
    }
}

// TC: O(m * n), SC: O(1)