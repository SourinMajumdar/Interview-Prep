// Link: https://leetcode.com/problems/pacific-atlantic-water-flow/
// Solution:
// https://www.youtube.com/watch?v=krL3r7MY7Dc
// https://www.youtube.com/watch?v=s-VkcjHqkGI
// https://www.youtube.com/watch?v=LVlihRYfVVw

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length, cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // dfs in top and bottom
        for (int i = 0; i < cols; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, rows - 1, i, Integer.MIN_VALUE, atlantic);
        }

        // dfs in left and right
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, cols - 1, Integer.MIN_VALUE, atlantic);
        }

        // checking for trues and putting the coordinates in res
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights, int i, int j, int prevHeight, boolean[][] ocean) {
        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length) return;
        if (heights[i][j] < prevHeight || ocean[i][j]) return;

        ocean[i][j] = true;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : dir)
            dfs(heights, i + d[0], j + d[1], heights[i][j], ocean);
    }
}

// TC: O(m * n), SC: O(m * n)