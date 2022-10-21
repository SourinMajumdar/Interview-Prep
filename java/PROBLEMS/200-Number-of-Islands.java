// Link: https://leetcode.com/problems/number-of-islands/
// Solution: https://www.youtube.com/watch?v=o8S2bO3pmO4


// We visit every element in grid and for the same we check if there exists islands in all four directions.

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands += dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    public int dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';

        dfs(grid, i - 1, j);    // going up
        dfs(grid, i + 1, j);    // going down
        dfs(grid, i, j - 1);    // going left
        dfs(grid, i, j + 1);    // going right

        return 1;
    }
}

// TC: O(N) - n is the number of elements in the image
// SC: O(N) - the size of the implicit call stack when calling dfs.
// N = m * n