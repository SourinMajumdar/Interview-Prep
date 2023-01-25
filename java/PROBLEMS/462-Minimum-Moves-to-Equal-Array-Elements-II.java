// Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/


class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = (n % 2 == 0)? (nums[n/2] + nums[n/2-1]) / 2 : nums[n/2];
        int ans = 0;
        for (int i : nums) {
            ans += Math.abs(i - m);
        }

        return ans;
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(1)


class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            ans += (nums[j--] - nums[i++]);
        }

        return ans;
    }
}

// TC: O(n * logn) + O(n/2) => O(n * logn)
// SC: O(1)