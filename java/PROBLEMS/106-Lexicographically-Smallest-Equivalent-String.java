// Link: https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
// https://www.youtube.com/watch?v=Go4eKBJyqIY


class Solution {
    private int[] u;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        u = new int[26];
        for (int i = 0; i < 26; i++) {
            u[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            int parent1 = findParent(s1.charAt(i));
            int parent2 = findParent(s2.charAt(i));
            if (parent1 < parent2) {
                u[parent2] = parent1;
            } else {
                u[parent1] = parent2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int parent = findParent(c);
            char f = (char) (parent + 'a');
            sb.append(f);
        }

        return sb.toString();
    }

    private int findParent(char c) {
        int parent = u[c - 'a'];
        while (u[parent] != parent) {
            parent = u[parent];
        }

        return parent;
    }
}

// TC: O(len(s1) + len(baseStr)), SC: O(1)