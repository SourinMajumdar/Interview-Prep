// Link: https://leetcode.com/problems/longest-palindrome/

// Solution: https://www.youtube.com/watch?v=noaGOtGmCzs

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                len += 2;
                set.remove(c);
            }
            else set.add(c);
        }

        return set.size() > 0 ? len + 1 : len;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int len = 0;

        for (int i : map.values()) {
            if (i % 2 == 0) len += i;
            else len += i - 1;
        }

        return len < s.length() ? len + 1 : len;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[128];

        for (char c : s.toCharArray()) {
            charCount[c]++;
        }

        int len = 0;

        for (int count : charCount) {
            len += 2 * (count / 2);
        }

        return len < s.length() ? len + 1 : len;
    }
}

// TC: O(n), SC: O(1)