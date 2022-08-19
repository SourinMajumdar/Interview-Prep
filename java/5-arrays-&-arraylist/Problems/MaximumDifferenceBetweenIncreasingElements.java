// Link: https://leetcode.com/problems/maximum-difference-between-increasing-elements/


class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int diff = nums[j] - nums[i];
                    if (diff > maxDiff) maxDiff = diff;
                }
            }
        }

        return maxDiff;
    }
}

// TC: O(n^2), SC: O(1)


class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            else {
                int currDiff = nums[i] - min;
                maxDiff = Math.max(currDiff, maxDiff);
            }
        }

        return maxDiff;
    }
}

// TC: O(n), SC: O(1)