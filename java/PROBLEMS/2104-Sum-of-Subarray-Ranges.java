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
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = max = nums[i];
            sum += (max - min);

            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (max - min);
            }
        }

        return sum;
    }
}

// TC: O(n ^ 2), SC: O(1)