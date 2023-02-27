// Link: https://leetcode.com/problems/construct-quad-tree/description/

class Solution {
    public Node construct(int[][] grid) {
        return help(grid, 0, 0, grid.length);
    }

    private Node help(int[][] a, int r, int c, int n) {
        boolean allSame = true;
        outerLoop:
        for (int i = r; i < r + n; i++)
            for (int j = c; j < c + n; j++)
                if (a[i][j] != a[r][c]) {
                    allSame = false;
                    break outerLoop;
                }

        if (allSame) {
            return new Node(a[r][c] == 1, true);
        }

        Node tL = help(a, r, c, n/2);
        Node tR = help(a, r, c + n/2, n/2);
        Node bL = help(a, r + n/2, c, n/2);
        Node bR = help(a, r + n/2, c + n/2, n/2);
        return new Node(false, false, tL, tR, bL, bR);
    }
}

// TC: O(n^2 * logn), SC: O(logn)