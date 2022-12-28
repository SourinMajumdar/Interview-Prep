/*
After we traverse a row:
        If top row -> increase value by one and move to next row
        if bottom row -> decrease value by one and move to previous row


After we traverse a column:
        If its left column -> Increase value by one and move to previous column
        if its right column -> decrease value by one and move to previous column
*/



class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        int firstR = 0, firstC = 0;
        int lastR = m - 1, lastC = n - 1;
        int d = 0;

        while (firstR <= lastR && firstC <= lastC) {
            // left to right
            if (d == 0) {
                for (int i = firstC; i <= lastC; i++) {
                    ans.add(matrix[firstR][i]);
                }
                d = 1;
                firstR++;
            }
            // top to bottom
            else if (d == 1) {
                for (int i = firstR; i <= lastR; i++) {
                    ans.add(matrix[i][lastC]);
                }
                d = 2;
                lastC--;
            }
            // right to left
            else if (d == 2) {
                for (int i = lastC; i >= firstC; i--) {
                    ans.add(matrix[lastR][i]);
                }
                d = 3;
                lastR--;
            }
            // bottom to top
            else if (d == 3) {
                for (int i = lastR; i >= firstR; i--) {
                    ans.add(matrix[i][firstC]);
                }
                d = 0;
                firstC++;
            }
        }

        return ans;
    }
}

// TC: O(m * n), SC: O(m * n)


