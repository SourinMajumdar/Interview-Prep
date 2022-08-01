//Problem: https://leetcode.com/problems/remove-element/
//Solution: https://www.youtube.com/watch?v=SKI8IirQZgo


class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }

        return j+1;
    }
}

// TC: O(N), SC: O(1)