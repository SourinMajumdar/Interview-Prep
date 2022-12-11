// Link: https://leetcode.com/problems/equal-row-and-column-pairs/description/

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<String, Integer> rows = new HashMap<>();
        Map<String, Integer> cols = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder r = new StringBuilder();
            StringBuilder c = new StringBuilder();

            for (int j = 0; j < n; j++) {
                r.append(grid[i][j]).append(' ');
                c.append(grid[j][i]).append(' ');
            }

            rows.put(r.toString(), rows.getOrDefault(r.toString(), 0) + 1);
            cols.put(c.toString(), cols.getOrDefault(c.toString(), 0) + 1);
        }

        int count = 0;

        for (String s : rows.keySet()) {
            if (cols.containsKey(s)) {
                count += rows.get(s) * cols.get(s);
            }
        }

        return count;
    }
}

// TC: O(n ^ 2) + O(n) ~ O(n ^ 2)
// SC: O(n + n) ~ O(n)