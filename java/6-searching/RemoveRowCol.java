// Searching in 2D arrays by removing rows and columns

import java.util.Arrays;
class BinarySearch2D{
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

        int target = 49;
        System.out.println(Arrays.toString(search2D(matrix, target)));
    }
    static int[] search2D(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col>=0) {
            if (matrix[row][col] == target){
                return new int[]{row, col};
            }else if (matrix[row][col] > target) {
                row++;
            }else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}