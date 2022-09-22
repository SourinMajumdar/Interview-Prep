// Link: https://leetcode.com/problems/reverse-vowels-of-a-string/
// Solution: https://www.youtube.com/watch?v=1NXs_idViuQ

class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(
                Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );

        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            while (i < j && !set.contains(chars[i])) i++;
            while (i < j && !set.contains(chars[j])) j--;

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