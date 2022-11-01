// Link: https://leetcode.com/problems/permutation-in-string/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        if (len1 > len2) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < len1; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arr1, arr2)) return true;

        int left = 0, right = len1;

        while (right < len2) {
            arr2[s2.charAt(right++) - 'a']++;
            arr2[s2.charAt(left++) - 'a']--;

            if (Arrays.equals(arr1, arr2)) return true;
        }

        return false;
    }
}

// TC: O(m + n), SC: O(1)