// Link: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String s : operations) {
            // the character at the index 1 would always be either - or +
            x += (s.charAt(1) == '+')? 1 : -1;
        }

        return x;
    }
}

// TC: O(n), SC: O(1)