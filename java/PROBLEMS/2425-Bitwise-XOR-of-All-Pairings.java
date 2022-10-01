// Link: https://leetcode.com/problems/bitwise-xor-of-all-pairings/
// Solution: https://www.youtube.com/watch?v=Vm7PEhv4DU4

// LeetCode BiWeeky 88, 1 Oct 2022
// Q3


class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                xor ^= (i ^ j);
            }
        }

        return xor;
    }
}

// TC: O(n * m)


class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int xor1 = 0 , xor2 = 0;

        for (int i : nums1) xor1 ^= i;
        for (int i : nums2) xor2 ^= i;

        int ans = 0;

        if (n % 2 == 1 && m % 2 == 0)  ans = xor2;
        else if (n % 2 == 0 && m % 2 == 1) ans = xor1;
        else if (n % 2 == 0 && m % 2 == 0) ans = 0;
        else ans = xor1 ^ xor2 ;

        return ans;
    }
}

// TC: O(n + m)


class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor = 0;

        if (nums1.length % 2 != 0) {
            for (int n : nums2) xor ^= n;
        }

        if (nums2.length % 2 != 0) {
            for (int n : nums1) xor ^= n;
        }

        return xor;
    }
}

// TC: O(n + m)