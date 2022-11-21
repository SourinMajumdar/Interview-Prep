// Link: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze


class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});

        maze[entrance[0]][entrance[1]] = '+';

        while (!q.isEmpty()) {
            int[] currPos = q.poll();
            int currRow = currPos[0], currCol = currPos[1], currSteps = currPos[2];

            for (int[] d : direction) {
                int nextRow = currRow + d[0];
                int nextCol = currCol + d[1];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n
                        && maze[nextRow][nextCol] == '.') {

                    if (nextRow == 0 || nextCol == 0 || nextRow == m - 1 || nextCol == n - 1) {
                        return currSteps + 1;
                    }

                    maze[nextRow][nextCol] = '+';
                    q.offer(new int[]{nextRow, nextCol, currSteps + 1});
                }
            }
        }

        return -1;
    }
}


// TC: O(m * n), SC: O(m * n)



class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        while (!q.isEmpty()) {
            int[] currPos = q.poll();
            int currRow = currPos[0], currCol = currPos[1], currSteps = currPos[2];

            for (int[] d : direction) {
                int nextRow = currRow + d[0];
                int nextCol = currCol + d[1];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n
                        && maze[nextRow][nextCol] == '.' && !visited[nextRow][nextCol] ) {

                    if (nextRow == 0 || nextCol == 0 || nextRow == m - 1 || nextCol == n - 1) {
                        return currSteps + 1;
                    }

                    visited[nextRow][nextCol] = true;
                    q.offer(new int[]{nextRow, nextCol, currSteps + 1});
                }
            }
        }

        return -1;
    }
}


// TC: O(m * n)
// SC: O(m * n) + O(m * n) => O(m * n)