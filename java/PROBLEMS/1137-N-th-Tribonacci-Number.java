// Link: https://leetcode.com/problems/n-th-tribonacci-number/

class Solution {
    public int tribonacci(int n) {
        if (n < 3) {
            return (n < 2)? n : 1;
        }

        int[] a = new inft[n+1];
        a[1] = a[2] = 1;

        for (int i = 3; i <= n; i++) {
            a[i] = a[i-1] + a[i-2] + a[i-3];
        }

        return a[n];
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public int tribonacci(int n) {
        if (n < 3) {
            return (n < 2)? n : 1;
        }

        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }

        return c;
    }
}

// TC: O(n), SC: O(1)