// Link: https://leetcode.com/problems/minimum-window-substring/


// Solution: https://www.youtube.com/watch?v=e1HlptlipB0 (Pepcoding)
class Solution {
    public String minWindow(String s, String t) {
        String ans = "";

        Map<Character, Integer> mapT = new HashMap<>();     // freq map for string t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        int desiredMatch = t.length();

        Map<Character, Integer> mapS = new HashMap<>();     // freq map for string s
        int i = -1, j = -1;

        while (true) {
            boolean loop1 = false, loop2 = false;

            // acquire
            while (i < s.length() - 1 && match < desiredMatch) {
                i++;
                char c = s.charAt(i);
                mapS.put(c, mapS.getOrDefault(c, 0) + 1);

                if (mapS.getOrDefault(c, 0) <= mapT.getOrDefault(c, 0)) {
                    match++;
                }

                loop1 = true;
            }

            // collect answers and release
            while (j < i && match == desiredMatch) {
                int potAns = i - j;     // potential answer length

                if (ans.length() == 0 || potAns < ans.length()) {
                    ans = s.substring(j + 1, i + 1);
                }

                j++;
                char c = s.charAt(j);

                if (mapS.get(c) == 1) mapS.remove(c);
                else mapS.put(c, mapS.get(c) - 1);

                if (mapS.getOrDefault(c, 0) < mapT.getOrDefault(c, 0)) {
                    match--;
                }

                loop2 = true;
            }

            if (!loop1 && !loop2) break;
        }

        return ans;
    }
}

// TC: O(t + s)
// SC: O(s) + O(t)

// Solution: https://www.youtube.com/watch?v=T9Mkjh_ZF80 (Coding Decoded)
class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int counter = t.length();

        while (end < s.length()) {
            char endC = s.charAt(end);
            if (freq[endC] > 0) counter--;

            freq[endC]--;
            end++;

            while (counter == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }

                char startC = s.charAt(start);
                freq[startC]++;
                if (freq[startC] > 0) counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}

// TC: O(t + s), SC: O(1)