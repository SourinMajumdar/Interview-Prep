/*
Problem : https://leetcode.com/problems/spiral-matrix-ii/submissions/

 */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int leftCol = 0, rightCol = n - 1;
        int topRow = 0, bottomRow = n - 1;
        int d = 0, num = 1;

        while (leftCol <= rightCol && topRow <= bottomRow){

            if(d == 0) {
                for (int i = leftCol; i <= rightCol; ++i){
                    matrix[topRow][i] = num++;
                }
                d = 1; topRow++;
            } else if (d == 1) {
                for (int i = topRow; i <=  bottomRow; ++i){
                    matrix[i][rightCol] = num++;
                }
                d = 2; rightCol--;
            } else if (d == 2) {
                for (int i = rightCol; i >= leftCol; i--){
                    matrix[bottomRow][i] = num++;
                }
                d = 3; bottomRow--;
            } else if (d == 3) {
                for (int i = bottomRow; i >= topRow; i--){
                    matrix[i][leftCol] = num++;
                }
                d = 0; leftCol++;
            }
        }

        return matrix;

    }
}