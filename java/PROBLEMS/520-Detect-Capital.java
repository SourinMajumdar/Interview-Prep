// Link: https://leetcode.com/problems/detect-capital/description/

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        }
        if (word.equals(word.toLowerCase())) {
            return true;
        }

        boolean firstLetterUppercase = false;
        boolean remLetterLowercase = true;
        int i = 0;

        for (char c : word.toCharArray()) {
            if (Character.toUpperCase(c) == c) {
                firstLetterUppercase = true;
            }
            if (i > 0 && Character.toUpperCase(c) == c) {
                remLetterLowercase = false;
            }
            i++;
        }

        return firstLetterUppercase && remLetterLowercase;
    }
}

// TC: O(n), SC: O(1)