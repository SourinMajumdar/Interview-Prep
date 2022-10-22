// Link: https://leetcode.com/problems/first-unique-character-in-a-string/


class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) map.put(c, i);
            else map.put(c, - 1);
        }

        int ans = s.length();

        for (char c : map.keySet()) {
            if (map.get(c) > -1 && map.get(c) < ans) {
                ans = map.get(c);
            }
        }

        return ans == s.length() ? -1 : ans;
    }
}

// TC: O(n), SC: O(1)