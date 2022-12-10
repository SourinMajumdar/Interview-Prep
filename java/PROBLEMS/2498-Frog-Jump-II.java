// Link: https://leetcode.com/problems/frog-jump-ii/description/

// biweekly 93, 10 Dec 2022
// Q3


class Solution {
    public int maxJump(int[] stones) {
        // int max = stones[1] - stones[0];
        if (stones.length == 2) {
            return stones[1] - stones[0];
        }

        int max = 0;

        for (int i = 2; i < stones.length; i++) {
            max = Math.max(max, stones[i] - stones[i - 2]);
        }

        return max;
    }
}


// TC: O(n), SC: O(1)