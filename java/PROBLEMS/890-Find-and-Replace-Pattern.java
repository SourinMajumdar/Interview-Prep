// Link: https://leetcode.com/problems/find-and-replace-pattern/


class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for (String s : words) {
            if (isIsomorphic(s, pattern)) {
                ans.add(s);
            }
        }

        return ans;
    }

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

// TC: O(n * k), SC: O(n)


// Similar question: 205, 290