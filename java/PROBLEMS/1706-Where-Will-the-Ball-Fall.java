// Link: https://leetcode.com/problems/where-will-the-ball-fall/

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];

        for (int col = 0; col < n; col++) {
            int curr = col;

            for (int row = 0; row < m; row++) {
                int next = curr + grid[row][curr];

                if (next < 0 || next >= n || grid[row][curr] != grid[row][next]) {
                    curr = -1;
                    break;
                }

                curr = next;
            }

            ans[col] = curr;
        }

        return ans;
    }
}

// TC: O(m * n), SC: O(n)