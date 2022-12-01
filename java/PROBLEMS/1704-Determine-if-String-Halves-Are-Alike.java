// Link: https://leetcode.com/problems/determine-if-string-halves-are-alike/

class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2);

        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int aCount = 0, bCount = 0;

        for (int i = 0; i < n / 2; i++) {
            if (set.contains(a.charAt(i))) aCount++;
            if (set.contains(b.charAt(i))) bCount++;
        }

        return aCount == bCount;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int i = 0, j = n / 2;

        Set<Character> set = Set.of(
                'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
        );

        int firstHalf = 0, secondHalf = 0;

        while (j < n) {
            if (set.contains(s.charAt(i++))) firstHalf++;
            if (set.contains(s.charAt(j++))) secondHalf++;
        }

        return firstHalf == secondHalf;
    }
}