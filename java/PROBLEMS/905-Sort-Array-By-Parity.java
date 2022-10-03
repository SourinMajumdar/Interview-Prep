// Link: https://leetcode.com/problems/sort-array-by-parity/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int t = 0;

        for (int n : nums) {
            if (n % 2 == 0) {
                ans[t++] = n;
            }
        }

        for (int n : nums) {
            if (n % 2 == 1) {
                ans[t++] = n;
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }

        return nums;
    }
}

// TC: O(n), SC: O(1)