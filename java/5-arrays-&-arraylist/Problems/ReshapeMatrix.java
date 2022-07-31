/*
Problem link: https://leetcode.com/problems/reshape-the-matrix/
Solution: https://www.youtube.com/watch?v=wCdNh9oThqk&t=33s
 */

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int columns = mat[0].length;

        if((rows * columns) != (r * c)) return mat;

        int[][] outputArr = new int[r][c];

        int rowNum = 0;;
        int columnNum = 0;

        for(int i=0; i<rows; ++i){
            for(int j=0; j<columns; ++j){
                outputArr[rowNum][columnNum] = mat[i][j];
                columnNum++;

                if(columnNum == c){
                    columnNum = 0;
                    rowNum++;
                }
            }
        }

        return outputArr;

    }
}


// TC: O(m*n), SC: O(r*c)