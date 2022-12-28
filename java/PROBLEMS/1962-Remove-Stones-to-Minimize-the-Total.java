// Link: https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/


class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int p : piles) {
            pq.offer(p);
        }

        while (k-- > 0) {
            int top = pq.poll();
            top = top / 2 + ((top % 2 == 0)? 0 : 1);
            pq.offer(top);
        }

        int rem = 0;
        while (!pq.isEmpty()) {
            rem += pq.poll();
        }

        return rem;
    }
}

// TC: O(n*logn) + O(k*2*logn) + O(n*logn) => O(n*logn)
// SC: O(n)