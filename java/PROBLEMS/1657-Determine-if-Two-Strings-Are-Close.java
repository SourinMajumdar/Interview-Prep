// Link: https://leetcode.com/problems/determine-if-two-strings-are-close/

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }

        // checks if characters are same in both words
        if (!map1.keySet().equals(map2.keySet())) return false;

        // to check if frequencies are equal in both words
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }
}

// TC: O(n + n * logn) => O(n * logn)
// SC: O(n)


class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        // checks if characters are same in both words
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq2[i] == 0 && freq1[i] != 0)) {
                return false;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : freq1) {
            if (i > 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        // checks if frequencies in word2 are same as word1
        for (int i : freq2) {
            if (i > 0) {
                if (!map.containsKey(i)) return false;

                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }

        return map.size() == 0;
    }
}

// TC: O(n), SC: O(n)