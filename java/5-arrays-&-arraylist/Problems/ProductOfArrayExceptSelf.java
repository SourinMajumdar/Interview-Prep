// Problem: https://leetcode.com/problems/product-of-array-except-self/
// Solution: https://www.youtube.com/watch?v=tSRFtR3pv74

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left_prod = new int[n];
        int[] right_prod = new int[n];
        int[] output = new int[n];

        left_prod[0] = right_prod[n - 1] = 1;

        for(int i = 1; i < n; i++) {    // going from left to right and taking products
            left_prod[i] = nums[i - 1] * left_prod[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {   // going from right to left and taking products
            right_prod[i] = nums[i + 1] * right_prod[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = left_prod[i] * right_prod[i];
        }

        return output;
    }
}

// TC: O(N); SC: O(N)



// Solution without using any extra space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        output[0] = 1;

        for(int i = 1; i < n; i++) {    // doing the work of left product
            output[i] = nums[i - 1] * output[i - 1];
        }

        int r = 1;
        for(int i = n - 1; i >= 0; i--) {   // doing the work of right product
            output[i] *= r;
            r *= nums[i];
        }

        return output;
    }
}

// TC: O(N), SC: O(1)