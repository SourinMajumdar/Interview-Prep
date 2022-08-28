// Link: https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/

class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) return new long[]{};

        long mid = num / 3;
        return new long[]{mid - 1, mid, mid + 1};
    }
}

// TC: O(1), SC: O(1)