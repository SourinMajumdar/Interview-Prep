// Problem : https://leetcode.com/problems/search-a-2d-matrix/
// Solution:

// Brute force approach: TC: O(m * n), SC: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if( matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}


// Little-bit optimised - TC: O(m + n), SC: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols - 1;

        while(i >= 0 && j >=0 && i < rows && j < cols) {
            if ( matrix[i][j] == target ) return true;
            else if ( matrix[i][j] > target ) j--;
            else i++;
        }

        return false;
    }
}

// optimised approach using BINARY SEARCH - TC: O(m*logn), SC: O(1)