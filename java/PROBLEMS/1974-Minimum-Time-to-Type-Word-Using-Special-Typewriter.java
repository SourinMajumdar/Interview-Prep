// Link: https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/description/

class Solution {
    public int minTimeToType(String word) {
        int ans = word.length();
        char curr = 'a';
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int steps = Math.abs(curr - c);
            ans += Math.min(steps, 26 - steps);
            curr = c;
        }

        return ans;
    }
}

// TC: O(n)