// Link: https://leetcode.com/problems/find-the-difference/
// Solution: https://www.youtube.com/watch?v=Ds4Kvd_xn4w

class Solution {
    public char findTheDifference(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) == 0 || !map.containsKey(c)) {
                return c;
            }

            map.put(c, map.get(c) - 1);
        }

        return '!';
    }
}

// TC: O(n); SC: O(n)