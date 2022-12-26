// Link: https://leetcode.com/problems/assign-cookies/description/


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++; j++;
            }
            else j++;

            /*
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;
            */
        }

        return count;
    }
}

// TC: O(g * logg) + O(s * logs) + O(min(g, s))
// SC: O(1)