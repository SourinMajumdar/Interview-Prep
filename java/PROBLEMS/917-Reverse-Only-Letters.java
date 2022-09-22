// Link: https://leetcode.com/problems/reverse-only-letters/

class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            while (i < j && !Character.isLetter(chars[i])) i++;
            while (i < j && !Character.isLetter(chars[j])) j--;

            // swap
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++; j--;
        }

        return new String(chars);
    }
}

// TC: O(n), SC: O(n)