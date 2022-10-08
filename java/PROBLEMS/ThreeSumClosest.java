/*
Problem: https://leetcode.com/problems/3sum-closest/
Solution: https://www.youtube.com/watch?v=qBr2hq4daWE
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;

            while(lo < hi) {
                int currentSum = nums[i] + nums[lo] + nums[hi];

                if(currentSum > target) hi--;
                else lo++;

                if(Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }
            }
        }
        return result;
    }
}