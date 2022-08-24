// Link: https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 2) + fib(n - 1);
    }
}

// TC: O(1.618 ^ n), SC: O(1)

// Fast - 0 ms
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
        int sum = a + b;

        while (n > 1) {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }

        return sum;
    }
}

// TC: O(n), SC: O(1)