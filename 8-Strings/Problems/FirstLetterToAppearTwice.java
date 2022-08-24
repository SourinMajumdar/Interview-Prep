// Link: https://leetcode.com/problems/first-letter-to-appear-twice/

class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) return c;
            set.add(c);
        }

        return ' ';
    }
}

// TC: O(n), SC: O(n)