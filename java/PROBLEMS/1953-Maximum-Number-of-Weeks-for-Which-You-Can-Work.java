// Link: https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/description/

class Solution {
    public long numberOfWeeks(int[] milestones) {
        long totalSum = 0, max = 0;

        for (int n : milestones) {
            totalSum += n;
            max = Math.max(max, n);
        }

        long sumExceptMax = totalSum - max;

        if (max > sumExceptMax) {
            return 1 + sumExceptMax * 2;
        }

        return totalSum;
    }
}

// TC: O(n), SC: O(1)