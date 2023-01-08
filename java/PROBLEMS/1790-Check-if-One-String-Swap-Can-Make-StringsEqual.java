// Link: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/


class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int[] f1 = new int[26];
        int[] f2 = new int[26];
        int count = 0;  // counts the number of indifferences
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 2) {    // same string not achievable by a single swap
                return false;
            }

            // build the frequency array
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        // if no other case, then character will have same frequencies
        // if given strings are already equal, that'll also be handled by this
        return Arrays.equals(f1, f2);
    }
}

// TC: O(n), SC: O(1)