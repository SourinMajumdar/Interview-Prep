// Link: https://leetcode.com/problems/increasing-triplet-subsequence/
// Solution: https://www.youtube.com/watch?v=9ACruzu6lXM


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > mid) return true;
            else if (n > left && n < mid) mid = n;
            else if (n < left) left = n;
        }

        return false;
    }
}

// TC: O(n), SC: O(1)


// Solution: https://www.youtube.com/watch?v=xZ5FBqk-cFw
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int[] leftMin = new int[n];
        leftMin[0] = nums[0];

        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.max(rightMin[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMin[i]) {
                return true;
            }
        }

        return false;
    }
}

// TC: O(n) + O(n) => O(n)
// SC: O(n) + O(n) => O(n)


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (nums[i] < nums[j] && nums[j] < nums[k])
                        return true;

        return false;
    }
}

// TC: O(n ^ 3), SC: O(1)