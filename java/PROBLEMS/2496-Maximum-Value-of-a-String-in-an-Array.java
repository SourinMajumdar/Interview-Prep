// Link: https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/description/

// Niweekly 93, 10 Dec 2022
// Q1


class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;

        for (String s : strs) {
            boolean onlyLetters = true;
            boolean onlyDigits = true;

            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    onlyLetters = false;
                }
                if (c >= 'a' && c <= 'z') {
                    onlyDigits = false;
                }
            }

            if (onlyDigits) {
                max = Math.max(max, Integer.parseInt(s));
            }
            else if (onlyLetters || !(onlyLetters && onlyDigits)) {
                max = Math.max(max, s.length());
            }
        }

        return max;
    }
}

// TC: O(n ^ 2), SC: O(1)


class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;

        for (String s : strs) {
            boolean onlyDigits = s.chars().allMatch(Character::isDigit);

            if (onlyDigits) max = Math.max(max, Integer.valueOf(s));
            else max = Math.max(max, s.length());
        }

        return max;
    }
}

// TC: O(n ^ 2), SC: O(1)