// Link: https://practice.geeksforgeeks.org/problems/maximum-sum-lcm3025/1


class Solution {
    static long maxSumLCM(int n) {
        long sum = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (n / i != i) {
                    sum += (n / i);
                }
            }
        }

        return sum;
    }
}

// TC: O(sqrt(n), SC: O(1)