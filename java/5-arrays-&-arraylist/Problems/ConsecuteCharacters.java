// Link: https://leetcode.com/problems/consecutive-characters/

class Solution {
    public int maxPower(String s) {
        int maxCount = 0, currCount = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) currCount++;
            else currCount = 0;

            maxCount = Math.max(maxCount, currCount);
        }

        return maxCount + 1;
    }
}

// TC: O(n), SC: O(1)
