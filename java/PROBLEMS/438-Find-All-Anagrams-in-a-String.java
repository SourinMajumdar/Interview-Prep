// Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
// https://www.youtube.com/watch?v=slDyFUnGtoU


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int left = 0, right = p.length();

        while (right < s.length()) {
            if (sMap.equals(pMap)) ans.add(left);

            // acquire the next char from the right
            char acquire = s.charAt(right);
            sMap.put(acquire, sMap.getOrDefault(acquire, 0) + 1);

            // get rid the first from extreme left of window
            char discard = s.charAt(left);
            if (sMap.get(discard) == 1) sMap.remove(discard);
            else sMap.put(discard, sMap.get(discard) - 1);

            // slide the window
            left++; right++;
        }

        if (sMap.equals(pMap)) ans.add(left);

        return ans;
    }
}

// TC: O(n) + O(m * n) + O(n) => O(m * n)
// SC: O(m + n)



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        int[] sHash = new int[26];
        int[] pHash = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pHash[p.charAt(i) - 'a']++;
            sHash[s.charAt(i) - 'a']++;
        }

        int left = 0, right = p.length();
        List<Integer> ans = new ArrayList<>();

        while (right < s.length()) {
            if (Arrays.equals(sHash, pHash)) ans.add(left);

            // acquire the next char from the right
            char acquire = s.charAt(right);
            sHash[acquire - 'a']++;

            // get rid the first from extreme left of window
            char discard = s.charAt(left);
            sHash[discard - 'a']--;

            // slide the window
            left++; right++;
        }

        if (Arrays.equals(sHash, pHash)) ans.add(left);

        return ans;
    }
}

// TC: O(n) + O(m * n) + O(n) => O(m * n)
// SC: O(1)