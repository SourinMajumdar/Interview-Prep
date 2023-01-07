// Link: https://leetcode.com/problems/find-xor-beauty-of-array/
// https://leetcode.com/problems/find-xor-beauty-of-array/solutions/3015170/java-pen-and-paper-proof/


// biweekly 95, 7 Jan 2023
// Q3

class Solution {
    public int xorBeauty(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }

        return xor;
    }
}

// TC: O(n), SC: O(1)