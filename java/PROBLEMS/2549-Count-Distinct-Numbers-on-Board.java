// Link: https://leetcode.com/problems/count-distinct-numbers-on-board/description/

// Weekly 330, 29 Jan 2023
// Q1

class Solution {
    public int distinctIntegers(int n) {
        return (n == 1)? n : n - 1;
    }
}

// TC: O(1)