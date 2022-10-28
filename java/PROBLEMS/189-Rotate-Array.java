// Problem : https://leetcode.com/problems/rotate-array/
// Solution: https://www.youtube.com/watch?v=gmu0RA5_zxs


class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public int[] reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }

        return nums;
    }
}

// TC: O(n), SC: O(1)



class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            ans[(i + k) % n] = nums[i];
        }

        for(int i = 0; i < n; i++){
            nums[i] = ans[i];
        }
    }
}