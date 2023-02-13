// Link: https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/

class Solution {
    private List<Integer>[] adj;
    private long fuel = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            adj[r[0]].add(r[1]);
            adj[r[1]].add(r[0]);
        }

        dfs(0, -1, seats);
        return fuel;
    }

    private int dfs(int node, int parent, int seats) {
        int people = 1;
        for (int child : adj[node]) {
            if (child != parent) {
                people += dfs(child, node, seats);
            }
        }
        if (node != 0) {
            fuel += Math.ceil(people * 1.0 / seats);
        }

        return people;
    }
}

// TC: O(n + e) => O(n + n - 1) => O(n)
// SC: O(n + e) => O(n)