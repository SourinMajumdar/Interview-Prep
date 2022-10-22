// Link: https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        Arrays.sort(S); Arrays.sort(T);

        return Arrays.equals(S, T);
    }
}

// TC: O(n * logn) + O(m * logm), SC: O(m + n)


class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char c : t.toCharArray()) freq[c - 'a']--;

        for (int i : freq) {
            if (i != 0) return false;
        }

        return true;
    }
}

// TC: O(m + n), SC: O(1)


class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        List<Character> list = new ArrayList<>();

        for (char c : s.toCharArray()) list.add(c);
        for (char c : t.toCharArray()) list.remove((Object) c);

        return list.size() == 0;
    }
}

// TC: O(m) + O(m * n)
// SC: O(m)



class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (int i : map.values()) {
            if (i != 0) return false;
        }

        return true;
    }
}

// TC: O(m + n), SC: O(m)




