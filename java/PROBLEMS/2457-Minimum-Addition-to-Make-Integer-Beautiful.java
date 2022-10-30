// link: https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/

class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long x = n, mul = 1;

        while (sum(x) > target) {
            x = x / 10 + 1;
            mul *= 10;
        }

        return x * mul - n;
    }

    public long sum(long n) {
        long sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}

// TC: O(logn * logn), SC: O(1)