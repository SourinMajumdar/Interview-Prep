// Link: https://leetcode.com/problems/smallest-even-multiple/

// Weekly 311, 18 September 2022
// Q1

class Solution {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}

// TC: O(1)