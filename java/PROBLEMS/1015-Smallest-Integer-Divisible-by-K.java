// Link: https://leetcode.com/problems/smallest-integer-divisible-by-k/

// Solution: https://www.youtube.com/watch?v=ZDUYcl4cB1s
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int n = 1, len = 1;

        while (n % k != 0) {
            n = (n * 10 + 1) % k;
            len++;
        }

        return len;
    }
}

// TC: O(k)

// Solution: https://www.youtube.com/watch?v=7zovdC157g0
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int rem = 0;

        for (int len = 1; len <= k; len++) {
            rem = (rem * 10 + 1) % k;
            if (rem == 0) return len;
        }

        return -1;
    }
}

// O(k)