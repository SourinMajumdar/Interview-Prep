// Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal/description/

class Solution {
    public int minOperations(int n) {
        int ops = 0;
        for (int i = 0; i < n / 2; i++) {
            int x = 2 * i + 1;
            ops += (n - x);
        }

        return ops;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public int minOperations(int n) {
        int mid = n / 2;
        return mid * ((n % 2 == 0)? mid : (mid + 1));
    }
}

// OR

class Solution {
    public int minOperations(int n) {
        int mid = n / 2;
        return mid * (mid + n % 2);
    }
}

// TC: O(1), SC: O(1)

