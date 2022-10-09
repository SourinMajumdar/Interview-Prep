// Link: https://leetcode.com/problems/find-the-original-array-of-prefix-xor/

class Solution {
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        for(int i = 0; i < pref.length - 1; i++){
            ans[i + 1] = pref[i] ^ pref[i + 1];
        }

        return ans;
    }
}

// TC: O(n), SC: O(1) - neglecting output array


class Solution {
    public int[] findArray(int[] pref) {
        for (int i = pref.length - 1; i > 0; --i) {
            pref[i] ^= pref[i - 1];
        }

        return pref;
    }
}

// TC: O(n)
// No extra space used at all