// Link: https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/description/


class Solution {
    public int minimumPartition(String s, int k) {
        int ans = 1;
        long num = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            long newNum = num * 10 + digit;
            if (newNum <= k) {
                num = newNum;
            } else {
                if (digit > k) {
                    return -1;
                }
                ans++;
                num = digit;
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)