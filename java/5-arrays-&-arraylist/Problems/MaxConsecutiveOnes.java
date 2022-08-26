// Link: https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;

        for (int n : nums) {
            if (n == 1) count++;
            else count = 0;
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}

// TC: O(n), SC: O(1)