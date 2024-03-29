// Link: https://leetcode.com/problems/largest-perimeter-triangle/

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }

        return 0;
    }
}

// TC: O(n) + O(n * logn) => O(n * logn)
// SC: O(1)