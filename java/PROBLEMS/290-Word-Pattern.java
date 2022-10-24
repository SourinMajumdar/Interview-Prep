// Link: https://leetcode.com/problems/word-pattern/


class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Boolean> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char S = pattern.charAt(i);
            String word = words[i];

            if (map1.containsKey(S)) {
                if (!map1.get(S).equals(word)) return false;
            }

            else {
                if (map2.containsKey(word)) return false;
                else {
                    map1.put(S, word);
                    map2.put(word, true);
                }
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(n)

// Similar question: 890, 205