// link: https://leetcode.com/problems/verifying-an-alien-dictionary/

class Solution {
    // create a global array (map) to store the order
    private int[] A = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        // populate the order array
        for (int i = 0; i < 26; i++) {
            A[order.charAt(i) - 'a'] = i;
        }
        // start iterating on words[]
        for (int i = 0; i < words.length - 1; i++) {
            // if current word is not smaller than next word
            if (!isSmaller(words[i], words[i+1])) {
                return false;
            }
            // otherwise check next pair
        }

        // when all words are lexicographically sorted
        return true;
    }

    private boolean isSmaller(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int n = Math.min(n1, n2);
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);   // current word's i-th character
            char c2 = s2.charAt(i);   // next word's i-th character
            // if c1 is less than c2, words are sorted
            if (A[c1 - 'a'] < A[c2 - 'a']) {
                return true;    // we don't need to check further
            }
            // or else if c1 > c2, words are unsorted
            else if (A[c1 - 'a'] > A[c2 - 'a']) {
                return false;
            }

            // Example: "apple" and "app"
            // we saw that "app" is common in both the strings
            // but beyond "app" lies more characters which is not allowed
            // if it were "apple" AFTER "app" it'd be sorted
            // but "apple" is before "app" which is unsorted

            // So we have reached the last index and so far the string was same
            // and we see that current word is longer than next word
            // which means the words are unsorted
            if (i == n - 1 && n1 > n2) {
                return false;
            }
        }

        // when we come out of the loop means s1 is smaller than s2
        return true;
    }
}

// TC: O(n), SC: O(1)