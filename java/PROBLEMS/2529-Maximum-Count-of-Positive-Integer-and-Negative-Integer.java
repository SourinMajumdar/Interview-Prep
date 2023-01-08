// Link: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/

// Weekly 327, 8 dec 2023
// Q1


class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int i : nums) {
            if (i < 0) neg++;
            else if (i > 0) pos++;
        }

        return Math.max(pos, neg);
    }
}

// TC: O(n), SC: O(1)