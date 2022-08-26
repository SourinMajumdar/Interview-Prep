// Link: https://leetcode.com/problems/max-consecutive-ones-iii/
// Solution: https://www.youtube.com/watch?v=7MK0GCSBoLg

class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, result = 0, zeroCount = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[i] == 0) zeroCount--;
                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}

// TC: O(n), SC: O(1)