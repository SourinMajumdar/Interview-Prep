// Link: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/description/

class Solution {
    public int minSteps(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        for (int i = 0; i < Math.max(s.length(), t.length()); i++) {
            if (i < s.length())
                sFreq[s.charAt(i) - 'a']++;
            if (i < t.length())
                tFreq[t.charAt(i) - 'a']++;
        }

        int ops = 0;
        for (int i = 0; i < 26; i++) {
            ops += Math.abs(sFreq[i] - tFreq[i]);
        }

        return ops;
    }
}

// TC: O(max(len(s), len(t)) + 26)
// SC: O(1)

