// Link: https://leetcode.com/problems/apply-bitwise-operations-to-make-strings-equal/description/

// weekly 329, 22 Jan 2023
// Q3


class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {     // if already equal
            return true;
        }
        // if both have 1s, return true, otherwise false
        return hasOnes(s) && hasOnes(target);
    }

    // method to check if the string has 1s
    private boolean hasOnes(String s) {
        for (char c : s.toCharArray()) {
            if (c == '1') {
                return true;
            }
        }

        return false;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
    }
}

// TC: O(n), SC: O(1)