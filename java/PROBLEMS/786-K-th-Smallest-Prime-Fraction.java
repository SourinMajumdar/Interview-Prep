// Link: https://leetcode.com/problems/k-th-smallest-prime-fraction/description/


class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                double x = a[0] / (1.0 * a[1]);
                double y = b[0] / (1.0 * b[1]);
                return x > y? -1 : 1;
            }
        );

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.offer(new int[] {arr[i], arr[j]});
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }
}

// TC: O(n^2 * logk), SC: O(k)

