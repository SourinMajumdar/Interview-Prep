// Link: https://leetcode.com/problems/count-pairs-of-similar-strings/description/

// weekly 324, 18 dec 2022
// Q1


class Solution {
    public int similarPairs(String[] words) {
        int n = words.length, count = 0;
        Set<Character> set1, set2;

        for (int i = 0; i < n - 1; i++) {
            set1 = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                set1.add(c);
            }
            for (int j = i + 1; j < n; j++) {
                set2 = new HashSet<>();
                for (char c : words[j].toCharArray()) {
                    set2.add(c);
                }
                if (set1.equals(set2)) count++;
            }
        }

        return count;
    }
}


// TC: O(n^2 * k)
// n is the length of array and k is the length of word in array

// SC: O(k)


class Solution {
    public int similarPairs(String[] words) {
        int n = words.length, count = 0;
        int[] a1, a2;
        Set<Character> set1, set2;

        for (int i = 0; i < n - 1; i++) {
            a1 = new int[26];
            for (char c : words[i].toCharArray()) {
                a1[c - 'a'] = 1;
            }

            for (int j = i + 1; j < n; j++) {
                a2 = new int[26];
                for (char c : words[j].toCharArray()) {
                    a2[c - 'a'] = 1;
                }

                if (Arrays.equals(a1, a2)) {
                    count++;
                }
            }
        }

        return count;
    }
}

// TC: O(n^2 * k)
// n is the length of array and k is the length of word in array

// SC: O(1)