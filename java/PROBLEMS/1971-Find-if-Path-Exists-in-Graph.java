// Link: https://leetcode.com/problems/find-if-path-exists-in-graph/description/
// https://www.youtube.com/watch?v=QC4bDHEnmLM


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) {
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            if (!map.containsKey(e[0])) {
                map.put(e[0], new ArrayList<>());
            }
            if (!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int vertex : map.get(v)) {
                if (!visited[vertex]) {
                    q.offer(vertex);
                    visited[vertex] = true;
                }
            }
        }

        return visited[destination];
    }
}

// TC: 2 * O(n * (n-1)) => O(n^2)
// SC: O(n^2) + O(n) + O(2 * n^2) => O(n^2)