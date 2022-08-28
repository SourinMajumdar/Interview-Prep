// Link: https://leetcode.com/problems/sort-the-matrix-diagonally/
// Solution:
// https://www.youtube.com/watch?v=-JA2x0yAxd4
// https://www.youtube.com/watch?v=JBqUl7avtG8


class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.computeIfAbsent(i - j, p -> new PriorityQueue()).add(mat[i][j]);
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }

        return mat;
    }
}

// TC: O(m * n * log(d))
// SC: O(m * n)
// d -> length of a diagonal

// ------------------------------------------------------------------

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        for (int col = 0; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }

        for (int row = 1; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }

        return mat;
    }

    void sortDiagonal(int[][] mat, int row, int col) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int r = row, c = col;

        while (r < mat.length && c < mat[0].length) {
            pq.add(mat[r++][c++]);
        }

        while (pq.size() > 0) {
            mat[row++][col++] = pq.poll();
        }
    }
}

// TC: O(m * n * log(d))
// SC: O((m + n - 1) * log(d))
// d -> length of a diagonal

// ------------------------------------------------------------------


class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        for (int col = 0; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }

        for (int row = 1; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }

        return mat;
    }

    void sortDiagonal(int[][] mat, int row, int col) {
        int m = mat.length, n = mat[0].length;
        int r = row, c = col;
        int[] values = new int[101];

        while (r < m && c < n) {
            values[mat[r++][c++]]++;
        }

        for (int i = 0; i < 101; i++) {
            if (values[i] > 0) {
                int count = values[i];
                while (count-- > 0) {
                    mat[row++][col++] = i;
                }
            }
        }
    }
}

// TC: O(m + n), SC: O(1)

