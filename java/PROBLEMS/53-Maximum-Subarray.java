/*
Problem: https://leetcode.com/problems/maximum-subarray/
Solution: https://www.youtube.com/watch?v=w_KEocd__20
 */

// Brute force
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i< nums.length; i++) {
            int currSum = 0;

            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(currSum, maxSum);
            }
        }

        return maxSum;
    }
}

// TC: O(n ^ 2), SC: O(1)


// Optimal (Kadane's algo)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; ++i){
            sum += nums[i];

            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
}

// TC: O(n), SC: O(1)