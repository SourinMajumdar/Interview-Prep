// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Solution: https://www.youtube.com/watch?v=qtVh-XEpsJo

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int len = 0;

        while (r < s.length()) {
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            r++;

            // if (len < r - l) len = r - l;
            // len = Math.max(len, r - l);
            len = Math.max(len, set.size());
        }

        return len;
    }
}

// TC: O(n) + O(n) => both l and r will iterate over the string at worst case
// SC: O(n)






class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        int l = 0, r = 0;

        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }

            map.put(s.charAt(r), r);
            len = Math.max(len, r - l + 1);
            r++;
        }

        return len;
    }
}

// TC: O(n), SC: O(n)
