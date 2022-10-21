// Problem : https://leetcode.com/problems/search-a-2d-matrix/

// Brute force approach: TC: O(m * n), SC: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) return true;
            }
        }

        return false;
    }
}


// staircase method - TC: O(m + n), SC: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;

        while(i < m && j >= 0) {
            if (matrix[i][j] > target) j-- ;
            else if (matrix[i][j] < target) i++ ;
            else return true;
        }

        return false;
    }
}

// Optimised approach using BINARY SEARCH - TC: O(log(m * n)), SC: O(1)
// Solution: https://www.youtube.com/watch?v=ZYpYur0znng

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = (m * n) - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (matrix[mid / n][mid % n] < target) {
                lo = mid + 1;
            }
            else if (matrix[mid / n][mid % n] > target) {
                hi = mid - 1;
            }
            else return true;
        }

        return false;
    }
}

// row index : mid / number of columns
// column index: mid % number of columns