// Link: https://leetcode.com/problems/count-vowel-strings-in-ranges/description/

// weekly 331, 5 Jan 2023
// Q2

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pref = new int[n];
        String s = words[0];
        if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {
            pref[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            s = words[i];
            boolean b = isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
            pref[i] = pref[i-1] + (b? 1 : 0);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = pref[r] - ((l == 0)? 0 : pref[l-1]);
        }

        return ans;
    }

    private boolean isVowel(char c) {
        return Set.of('a', 'e', 'i', 'o', 'u').contains(c);
    }
}

/*
    Let n and k be the length of the arrays words and queries respectively.

    Time complexity: O(n + k)
    Space complexity: O(n + k)

 */