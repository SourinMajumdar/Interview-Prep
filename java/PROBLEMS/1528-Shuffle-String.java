// Link: https://leetcode.com/problems/shuffle-string/

class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] ans = new char[n];

        for (int i = 0; i < n; i++) {
            ans[indices[i]] = s.charAt(i);
        }

        return String.valueOf(ans);
    }
}

// TC: O(n), SC: O(n)