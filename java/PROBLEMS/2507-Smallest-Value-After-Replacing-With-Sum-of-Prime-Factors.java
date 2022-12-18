// Link: https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/description/

// weekly 324, 18 dec 2022
// Q2


class Solution {
    public int smallestValue(int n) {
        int ori = n, ans = n;
        int k = 2, sum = 0;

        while (true) {
            if (n % k == 0) {
                sum += k;
                n /= k;
            }
            else k++;

            if (n == 1) {
                if (sum == ori) {
                    break;
                }
                ori = n = sum;
                sum = 0;
                k = 2;
                ans = Math.min(ans, n);
            }
        }

        return ans;
    }
}

// TC: O(