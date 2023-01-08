// Link: https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/

// Weekly 327, 8 dec 2023
// Q2

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            pq.offer(i);
        }

        long score = 0;
        while (k-- > 0) {
            int x = pq.poll();
            score += x;
            x = (int) Math.ceil(x * 1.0 / 3.0);
            pq.offer(x);
        }

        return score;
    }
}

// TC: O(n) + O(k * logn) => O(k * logn)
// SC: O(1)