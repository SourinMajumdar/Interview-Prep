// Link: https://leetcode.com/contest/weekly-contest-322/problems/circular-sentence/

// Weekly 322, 4 Dec 2022
// Q1

class Solution {
    public boolean isCircularSentence(String s) {
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != s.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)