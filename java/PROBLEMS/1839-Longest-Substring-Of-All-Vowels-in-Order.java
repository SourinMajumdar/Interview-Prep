// Link: https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/


class Solution {
    public int longestBeautifulSubstring(String word) {
        int maxLen = 0, vowels = 1, currLen = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                currLen++;
            }
            else if (word.charAt(i) >= word.charAt(i - 1)) {
                currLen++;
                vowels++;
            }
            else {              // word.charAt(i) < word.charAt(i - 1)
                currLen = 1;
                vowels = 1;
            }

            if (vowels == 5) maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}

// TC: O(n), SC: O(1)