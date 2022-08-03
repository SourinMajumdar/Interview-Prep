// Problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// Solution: https://www.youtube.com/watch?v=w36ekZYq-Ms

// Brute force approach - TC: O(n * n * logk), SC: O(k)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);

                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}

// Optimized approach - TC: O(____), SC: O(1) - Binary search

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = counter(matrix, mid);

            if( count < k ) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

    int counter(int[][] matrix, int mid) {
        int n = matrix.length;
        int row = 0;
        int col = n - 1;
        int count = 0;
        while (row < n && col >= 0) {
            if (matrix[row][col] > mid) {
                col--;
            } else {
                count += col + 1;
                row++;
            }
        }
        return count;
    }
}