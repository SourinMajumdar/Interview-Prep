/*
Problem link: https://leetcode.com/problems/reshape-the-matrix/
Solution: https://www.youtube.com/watch?v=wCdNh9oThqk&t=33s
 */

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int size = mat.length * mat[0].length;

        if(size != r * c) return mat;

        int[][] ans = new int[r][c];
        int currRow = 0, currCol = 0;

        for (int[] row : mat) {
            for (int n : row) {
                ans[currRow][currCol++] = n;

                if(currCol == c){
                    currCol = 0;
                    currRow++;
                }
            }
        }

        return ans;
    }
}


// TC: O(m * n), SC: O(r * c)