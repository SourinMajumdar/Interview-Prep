// Link: https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/description/

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int seconds = 0;
        while (s.contains("01")) {
            s = s.replace("01", "10");
            seconds++;
        }

        return seconds;
    }
}

// TC: O(n ^ 2)