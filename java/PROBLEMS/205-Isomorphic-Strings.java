// Link: https://leetcode.com/problems/isomorphic-strings/
// Solution: https://www.youtube.com/watch?v=6Qkail843d8

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Boolean> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char S = s.charAt(i);
            char T = t.charAt(i);

            if (map1.containsKey(S)) {
                if (map1.get(S) != T) return false;
            }

            else {
                if (map2.containsKey(T)) return false;
                else {
                    map1.put(S, T);
                    map2.put(T, true);
                }
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(n)


// Similar question: 890, 290