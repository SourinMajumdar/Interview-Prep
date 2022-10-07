// Link: https://leetcode.com/problems/counting-words-with-a-given-prefix/

class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for (String s : words) {
            if (s.startsWith(pref)) count++;
        }

        return count;
    }
}

// TC: O(n)