// Link: https://leetcode.com/problems/make-number-of-distinct-characters-equal/description/

// Weekly 327, 8 dec 2023
// Q3

class Solution {
    public boolean isItPossible(String word1, String word2) {
        // record the frequencies
        int[] f1 = getFreq(word1);
        int[] f2 = getFreq(word2);

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                // if frequency is 0 we can't swap
                if (!(f1[i] > 0 && f2[j] > 0)) {
                    continue;
                }

                // simulate swap
                f1[i]--; f2[i]++;   // frequency moves from f1 to f2
                f2[j]--; f1[j]++;   // frequency moves from f2 to f1

                // if distinct counts are equal, return true right away
                if (areCharsDistinct(f1, f2)) {
                    return true;
                }

                // otherwise, revert the swap
                f1[i]++; f2[j]++;
                f1[j]--; f2[i]--;
            }
        }

        return false;
    }

    // this function tells us if the count of distinct characters
    // in both strings are equal after swapping
    private boolean areCharsDistinct(int[] a, int[] b) {
        int d1 = 0, d2 = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i] > 0) d1++;
            if (b[i] > 0) d2++;
        }

        return d1 == d2;
    }

    // frequency array builder
    private int[] getFreq(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }

        return f;
    }
}

// TC: O(26 * 26 * (26 + 26)) => O(1)
// SC: O(26 + 26) => O(1)