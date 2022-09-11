// Link: https://leetcode.com/problems/non-decreasing-array/

// Solution: https://www.youtube.com/watch?v=KpNPa4tVLrc&t=0s
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i >= 2 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }

        return count <= 1;
    }
}

// TC: O(n), SC: O(1)


// Solution: https://www.youtube.com/watch?v=RegQckCegDk
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean changed = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) continue;
            if (changed) return false;

            if (i == 0 || nums[i + 1] >= nums[i - 1]) {
                nums[i] = nums[i + 1];
            } else {
                nums[i + 1] = nums[i];
            }

            changed = true;
        }

        return true;
    }
}

// TC: O(n), SC: O(1)