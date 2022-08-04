// Problem link: https://leetcode.com/problems/jump-game/
// Solution: https://www.youtube.com/watch?v=Yan0cv2cLy8

// Greedy approach

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;

        for (int i = goal; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}

// TC: O(N), SC: O(1)