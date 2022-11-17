// Link: https://leetcode.com/problems/length-of-last-word/

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpaceIdx = s.lastIndexOf(' ');
        return s.length() - lastSpaceIdx - 1;
    }
}

// TC: O(n)


class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') length++;
            else if (length > 0) break;
        }

        return length;
    }
}

// TC: O(n), SC: O(1)