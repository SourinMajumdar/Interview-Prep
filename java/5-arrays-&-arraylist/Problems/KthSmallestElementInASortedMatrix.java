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

// Optimized approach -