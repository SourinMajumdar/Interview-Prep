// Link: https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 2) + fib(n - 1);
    }
}

// TC: O(1.618 ^ n), SC: O(n) - recursion call stack

// Fast - 0 ms
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
        int sum = a + b;

        while (n-- > 1) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    int[] dp = new int[31];

    public int fib(int n) {
        if (n <= 1) return n;
        if (dp[n] > 0) return dp[n];

        return dp[n] = fib(n - 2) + fib(n - 1);
    }
}

// TC: O(n), SC: O(n) - recursion call stack