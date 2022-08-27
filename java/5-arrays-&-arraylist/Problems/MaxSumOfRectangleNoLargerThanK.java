// Link: https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
// Solution: https://www.youtube.com/watch?v=okX_0RT1vZE

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        int rows = matrix.length, cols = matrix[0].length;

        for (int left = 0; left < cols; left++) {
            int[] sum = new int[rows];

            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    sum[i] += matrix[i][right];
                }
                result = Math.max(result, validSum(sum, k));
            }
        }

        return result;
    }

    int validSum(int[] arr, int k) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum <= k) max = Math.max(max, sum);
            }
        }

        return max;
    }
}


/*

TC:

m = rows size
m = col size

Inside Helper :
-> n + (n-1) + (n-2) + ... + 1 = O(n^2)

Main code :
-> m + (m-1) + (m-2) + ... + 1 = O(m^2)
And we are running m times for each loop
-> O(m^2 * n)

And Helper also we are running for all O(n^2) times
So, O(m^2 * n + m^2 * n^2) will be time complexity
Therefore, roughly 'O(m^2 * n^2)'



SC: O(m)
m -> Number of rows

*/