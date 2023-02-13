// Link: https://leetcode.com/problems/substring-xor-queries/description/

// weekly 332, 12 Feb 2023
// Q3


class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                map.putIfAbsent(0, new int[] {i, i});
                continue;
            }

            for (int j = i; j < s.length() && j < i + 32; j++) {
                int num = Integer.parseInt(s.substring(i, j + 1), 2);
                map.putIfAbsent(num, new int[] {i, j});
            }
        }

        int[][] ans = new int[queries.length][2];
        int i = 0;
        for (int[] q : queries) {
            int val = q[0] ^ q[1];
            ans[i++] = map.getOrDefault(val, new int[] {-1, -1});
        }

        return ans;
    }
}

// TC: O(n ∗ min(n, 32)) + O(n)
// SC: O(n^2)