// Link: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int idx = Integer.MAX_VALUE;

        int i = 0;
        for (String s : words) {
            i++;
            if (s.startsWith(searchWord)) {
                idx = Math.min(idx, i);
            }
        }

        return idx == Integer.MAX_VALUE ? -1 : idx;
    }
}

// TC: O(n), SC: O(n)