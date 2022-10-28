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
        int l = 0, r = n - 1;
        int idx = n - 1;

        int[] ans = new int[n];

        while (l <= r) {
            int sql = nums[l] * nums[l];
            int sqr = nums[r] * nums[r];

            if (sql > sqr) {
                ans[idx] = sql;
                l++;
            }
            else {
                ans[idx] = sqr;
                r--;
            }
            idx--;
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)