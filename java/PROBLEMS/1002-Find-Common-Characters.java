// Link: https://leetcode.com/problems/find-common-characters/
// Solution: https://www.youtube.com/watch?v=k1iowWJimbg

class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);    // O(1)

        for (String s : words) {    // O(n)
            int[] currFreq = new int[26];

            for (char c : s.toCharArray()) {    // O(n)
                currFreq[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(currFreq[i], minFreq[i]);
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- != 0) {
                ans.add((char)(i + 'a') + "");
            }
        }

        return ans;
    }
}

// TC: O(n ^ 2)
// SC: O(n) - All words can be same in words array