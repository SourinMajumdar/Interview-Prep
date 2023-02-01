// Link: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ab = nums[0] * nums[1];
        int cd = nums[n-1] * nums[n-2];
        return cd - ab;
    }
}

// TC: O(n * logn), SC: O(1)


class Solution {
    public int maxProductDifference(int[] nums) {
        int max = 0, max2 = 0;
        int min = 10001, min2 = 10001;
        for (int i : nums) {
            if (i > max) {
                max2 = max;
                max = i;
            } else if (i > max2) {
                max2 = i;
            }
            if (i < min) {
                min2 = min;
                min = i;
            } else if (i < min2) {
                min2 = i;
            }
        }

        return max * max2 - min * min2;
    }
}

// TC: O(n), SC: O(1)