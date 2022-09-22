// Link: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/


// Brute force
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int n : row) {
                if (n < 0) count++;
            }
        }

        return count;
    }
}

// TC: O(m * n), SC: O(1)




// Row wise Binary search

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int[] row : grid) {
            count += countRowWise(row);
        }

        return count;
    }

    int countRowWise(int[] mat) {
        int lo = 0, hi = mat.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mat[mid] >= 0) {
                lo = mid + 1;
            }
            else hi = mid - 1;

        }

        return mat.length - hi - 1;
    }
}

// TC: O(m * logn), SC: O(1)



// Better (staircase)
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int row = 0, col = grid[0].length - 1;

        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                count += (grid.length - row);
                col--;
            }
            else row++;
        }

        return count;
    }
}

// TC: O(m + n), SC: O(1)