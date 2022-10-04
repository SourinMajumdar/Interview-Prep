// Link: https://leetcode.com/problems/squares-of-a-sorted-array/

class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
}

// TC: O(n) + O(n * logn) => O(n * logn)


class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int idx = n - 1;
        int l = 0, r = n - 1;

        int[] ans = new int[n];

        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                ans[idx] = nums[l] * nums[l];
                l++;
            }
            else {
                ans[idx] = nums[r] * nums[r];
                r--;
            }

            idx--;
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)