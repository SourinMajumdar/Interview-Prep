// Link: https://leetcode.com/problems/count-prefixes-of-a-given-string/

class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;

        for (String str : words) {
            // if (s.indexOf(str) == 0) count++;
            if (s.startsWith(str)) count++;
        }

        return count;
    }
}