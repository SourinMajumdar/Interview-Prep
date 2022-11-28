// Link: https://leetcode.com/problems/sum-of-subarray-ranges/

// 70/71
class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int k = j; k <= i; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }

                sum += (max - min);
            }
        }

        return sum;
    }
}

// TC: O(n ^ 3, SC: O(1)


// AC
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int max = nums[i], min = nums[i];

            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += (max - min);
            }
        }

        return sum;
    }
}

// TC: O(n ^ 2), SC: O(1)