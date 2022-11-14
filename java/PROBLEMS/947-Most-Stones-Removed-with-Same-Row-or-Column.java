// Link: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/


class Solution {
    Set<int[]> visited = new HashSet<>();

    public int removeStones(int[][] stones) {
        int numOfIslands = 0;

        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                dfs(stone, stones);
                numOfIslands++;
            }
        }

        return stones.length - numOfIslands;
    }

    private void dfs(int[] stone, int[][] stones) {
        visited.add(stone);

        for (int[] s : stones)
            if (!visited.contains(s))
                if (stone[0] == s[0] || stone[1] == s[1])
                    dfs(s, stones)
    }
}

// TC: O(n ^ 2), SC: O(n)