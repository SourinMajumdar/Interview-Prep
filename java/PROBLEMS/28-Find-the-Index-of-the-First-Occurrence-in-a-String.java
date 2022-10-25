// Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/


class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = needle.length();

        while (j < haystack.length() + 1) {
            String s = haystack.substring(i, j);
            if (s.equals(needle)) return i;
            i++; j++;
        }

        return -1;
    }
}

// TC: O(n ^ 2), SC: O(1)


class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// TC: O(n), SC: O(1)