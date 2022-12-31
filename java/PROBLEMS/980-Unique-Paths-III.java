// Link: https://leetcode.com/problems/unique-paths-iii/description/


class Solution {
    private int paths = 0, zeros = 0;
    public int uniquePathsIII(int[][] grid) {
        int x = 0, y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) zeros++;
                else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        dfs(grid, x, y, 0);
        return paths;
    }

    public void dfs(int[][] a, int i, int j, int count) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == -1) {
            return;
        }
        if (a[i][j] == 2) {
            if (count == zeros + 1) paths++;
            return;
        }

        a[i][j] = -1;

        dfs(a, i + 1, j, count + 1);
        dfs(a, i - 1, j, count + 1);
        dfs(a, i, j + 1, count + 1);
        dfs(a, i, j - 1, count + 1);

        a[i][j] = 0;
    }
}

// TC: O(m * n) + O(4^n)
// SC: O(m * n)