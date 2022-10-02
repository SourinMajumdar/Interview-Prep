// Link: https://leetcode.com/problems/remove-letter-to-equalize-frequency/
// Solution: https://www.youtube.com/watch?v=onYybEuaIpg

// BiWeekly 88, 1 Oct 2022
// Q1

class Solution {
    public boolean equalFrequency(String word) {
        for (int i = 0; i < word.length(); i++) {
            StringBuilder temp = new StringBuilder(word);
            temp.deleteCharAt(i);
            String str = temp.toString();

            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            Set<Integer> set = new HashSet<>();
            for (int f : freq) {
                if (f > 0) set.add(f);
            }

            if (set.size() == 1) return true;
        }

        return false;
    }
}

// TC: O(n * (2 * 26)) => O(n)
// SC: O(1)


class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int[] freq = new int[map.size()];

        int i = 0;
        for (int f : map.values()) {
            freq[i++] = f;
        }

        Arrays.sort(freq);
        int n = freq.length;

        if (n == 1) return true;

        if (freq[0] == 1 && freq[1] == freq[n - 1]) {
            return true;
        }

        if (freq[0] == freq[n - 2] && freq[n - 1] - freq[n - 2] == 1) {
            return true;
        }

        return false;
    }
}

// TC: O(n * logn)
// SC: O(n)