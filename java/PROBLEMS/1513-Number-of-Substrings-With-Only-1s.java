// Link: https://leetcode.com/problems/number-of-substrings-with-only-1s/
// Solution: https://www.youtube.com/watch?v=DNUiFNIV4j4

class Solution {
    public int numSub(String s) {
        int count = 0, total = 0, mod = 1_000_000_007;

        for (char c : s.toCharArray()) {
            count = (c == '1') ? count + 1 : 0;
            total = (total + count) % mod;
        }

        return total;
    }
}

// TC: O(n), SC: O(1)