/*
Problem: https://leetcode.com/problems/3sum-closest/
Solution: https://www.youtube.com/watch?v=qBr2hq4daWE
 */

// Full brute force:
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int finalSum = nums[0] + nums[1] + nums[n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(target - sum) < Math.abs(target - finalSum)) {
                        finalSum = sum;
                    }
                }
            }
        }

        return finalSum;
    }
}

// TC: O(n ^ 3), SC: O(1)




class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int finalSum = nums[0] + nums[1] + nums[n - 1];

        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = n - 1;

            while (lo < hi) {
                int currSum = nums[i] + nums[lo] + nums[hi];

                if (currSum < target) lo++;
                else hi--;

                if (Math.abs(target - currSum) < Math.abs(target - finalSum)) {
                    finalSum = currSum;
                }
            }
        }

        return finalSum;
    }
}

// TC: O(n ^ 2), SC: O(1)