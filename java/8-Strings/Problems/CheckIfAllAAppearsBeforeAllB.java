// Link: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

//Checking is string is sorted

class Solution {
    public boolean checkString(String s) {

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)