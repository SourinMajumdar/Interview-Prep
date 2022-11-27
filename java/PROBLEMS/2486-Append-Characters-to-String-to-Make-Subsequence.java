// Link: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

// weekly 321, 27 Nov 2022
// Q2

class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }

            i++;
        }

        return t.length() - j;
    }
}

// TC: O(n), SC: O(1)