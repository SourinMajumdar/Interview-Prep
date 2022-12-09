// Link: https://leetcode.com/problems/three-divisors/description/

class Solution {
    public boolean isThree(int n) {
        if (n < 3) return false;

        int count = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) count++;
            if (count > 1) return false;
        }

        return count != 0;
    }
}

// TC: O(n), SC: O(1)



class Solution {
    public boolean isThree(int n) {
        if (n < 3) return false;

        int i = 2;
        for (; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return i * i == n;
    }
}

// TC: O(sqrt(n)), SC: O(1)