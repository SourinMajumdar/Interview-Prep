// Link: https://leetcode.com/problems/sum-of-two-integers/
// Solution: https://www.youtube.com/watch?v=gVUrDV4tZfY

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a ^= b;
            b = temp;
        }

        return a;
    }
}

// TC: O(1), SC: O(1)