// Link: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0 && set.contains(freq[i])) {
                freq[i]--;
                ans++;
            }
            set.add(freq[i]);
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)