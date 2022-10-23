// Link: https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/

// Weekly 316, 23 Oct 2022
// Q2

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currGCD = nums[i];

            for (int j = i; j < n; j++) {
                currGCD = gcd(currGCD, nums[j]);
                ans += (currGCD == k) ? 1 : 0;
            }
        }

        return ans;
    }

    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}

// TC: O(n ^ 2)