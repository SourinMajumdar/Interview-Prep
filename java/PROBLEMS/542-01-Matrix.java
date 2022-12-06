// Link: https://leetcode.com/problems/01-matrix/
// coding decoded

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
                else mat[i][j] = -1;
            }
        }

        int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        int length = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            length++;

            while (size-- > 0){
                int[] cell = q.poll();

                for (int[] dir : dirs){
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];

                    if (r < 0 || c < 0 || r >= m || c >= n || mat[r][c] != -1) {
                        continue;
                    }

                    mat[r][c] = length;
                    q.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}

// TC O(m * n), SC: O(m * n)


// GFG: https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
class Solution {
    public int[][] nearest(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] ans = new int[m][n];
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0){
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                ans[x][y] = distance;

                for (int[] dir : dirs){
                    int r = x + dir[0];
                    int c = y + dir[1];

                    if (r >= 0 && c >= 0 && r < m && c < n && !visited[r][c]) {
                        visited[r][c] = true;
                        queue.add(new int[]{r, c});
                    }
                }
            }

            distance++;
        }

        return ans;
    }
}

