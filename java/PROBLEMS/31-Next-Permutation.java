// Link: https://leetcode.com/problems/next-permutation/
// Solution: https://www.youtube.com/watch?v=LuLCLgMElus&t=1s

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int index) {
        int end = nums.length - 1;
        while (index < end) swap(nums, index++, end--);
    }
}


// TC: O(n) + O(n) + O(n) => O(n)
// SC: O(1)