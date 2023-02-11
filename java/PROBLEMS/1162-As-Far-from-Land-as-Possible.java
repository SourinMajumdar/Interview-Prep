// Link: https://leetcode.com/problems/as-far-from-land-as-possible/

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                for (int[] d : dir) {
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= n || grid[newX][newY] != 0) {
                        continue;
                    }
                    grid[newX][newY] = 1 + grid[x][y];
                    result = Math.max(result, grid[newX][newY]);
                    q.add(new int[] {newX, newY});
                }
            }
        }

        return result == 0? -1 : --result;
    }
}

// TC: O(n^2), SC: O(n^2)