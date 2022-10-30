// Link: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

// https://www.youtube.com/watch?v=ID9YJXy3OJk


class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][][] visited = new boolean[m][n][k + 1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, k});

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();

                // if curr is destination, return steps
                if (curr[0] == m - 1 && curr[1] == n - 1) {
                    return steps;
                }

                // traverse through valid cells
                for (int[] d : dir) {
                    int i = curr[0] + d[0];
                    int j = curr[1] + d[1];
                    int obs = curr[2];

                    // check if position inside bounds
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        // if cell is empty, visit the cell and add it in queue
                        if (grid[i][j] == 0 && !visited[i][j][obs]) {
                            q.offer(new int[] {i, j, obs});
                            visited[i][j][obs] = true;
                        }
                        // if cell has obstacle and we can eliminate it, visit it and add it in queue
                        // decrement 'obstacle eliminations left that can be performed'
                        else if (grid[i][j] == 1 && obs > 0 && !visited[i][j][obs - 1]) {
                            q.offer(new int[]{i, j, obs - 1});
                            visited[i][j][obs - 1] = true;
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}

// TC: O(m * n * k), SC: O(m * n * k)