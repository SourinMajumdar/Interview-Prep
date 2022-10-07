/*
Problem link: https://leetcode.com/problems/matrix-diagonal-sum/
Solution: https://www.youtube.com/watch?v=nqVbUdNqQlE
*/

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for(int i = 0; i < n; ++i){
            sum += (mat[i][i] + mat[i][n - i - 1]);
        }

        return (n % 2 == 0) ? sum : sum - mat[n / 2][n / 2];
    }
}



class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
        }

        for (int r = 0, j = n - 1; j >= 0; j--, r++) {
            sum += mat[r][j];
        }

        return (n % 2 == 0) ? sum : sum - mat[n / 2][n / 2];
    }
}

// TC: O(n)