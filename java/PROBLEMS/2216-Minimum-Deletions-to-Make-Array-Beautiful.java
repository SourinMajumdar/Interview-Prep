// Link: https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
// Solution: https://www.youtube.com/watch?v=XejmsXnV34c

class Solution {
    public int minDeletion(int[] nums) {
        int delet = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int newIndex = i - delet;
            if (newIndex % 2 == 0 && nums[i] == nums[i + 1]) {
                delet++;
            }
        }

        return (n - delet) % 2 == 0 ? delet : delet + 1;
    }
}

// TC: O(n), SC: O(1)