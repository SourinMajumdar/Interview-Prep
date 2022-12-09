// Link: https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/

class Solution {
    public int findGCD(int[] nums) {
        int max = 0, min = 10001;

        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        return gcd(max, min);
    }

    private int gcd(int a, int b) {
        return (b == 0)? a : gcd(b, a % b);
    }
}

// TC: O(n)