// Link: https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/

// Biweekly 92, 26 Nov 2022
// Q1


class Solution {
    public int numberOfCuts(int n) {
        return (n == 1)? 0 : ((n % 2 == 0)? n / 2 : n);
    }
}


class Solution {
    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        return (n % 2 == 0) ? n / 2 : n;

    }
}

// TC: O(1), SC: O(1)