// Link: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int f = freq[s.charAt(0) - 'a'];
        for (int i : freq) {
            if (i != 0) {
                if (i != f) return false;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)