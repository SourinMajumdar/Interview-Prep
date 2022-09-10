// Link: https://leetcode.com/problems/reverse-words-in-a-string/
// Solution: https://www.youtube.com/watch?v=g9xgkIjfpWY

class Solution {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        String ans = "";

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;

            int j = i;

            if (i < 0) break;

            while (i >= 0 && s.charAt(i) != ' ') i--;

            if (ans.isEmpty()) ans = ans.concat(s.substring(i + 1, j + 1));
            else ans = ans.concat(" " + s.substring(i + 1, j + 1));
        }

        return ans;
    }
}

// -------------------------------------------------------------------

class Solution {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        StringBuilder ans = new StringBuilder();

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;

            int j = i;

            if (i < 0) break;

            while (i >= 0 && s.charAt(i) != ' ') i--;

            if (ans.isEmpty()) ans.append(s.substring(i + 1, j + 1));
            else ans = ans.append(" " + s.substring(i + 1, j + 1));
        }

        return ans.toString();
    }
}

// TC: O(n), SC: O(1)
