// Link: https://leetcode.com/problems/k-closest-points-to-origin/

// https://www.youtube.com/watch?v=r7DwTstWSEI


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] arr : points) {
            pq.offer(arr);
            if (pq.size() > k) pq.poll();
        }

        int[][] ans = new int[k][2];

        while (k-- > 0) {
            ans[k] = pq.poll();
        }

        return ans;
    }
}

// TC: O(n * logk) + O(k * logk) => O(n * logk)
// SC: O(k)