// Link: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
// https://www.youtube.com/watch?v=qSBvKlUq0xo

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // create the adjacency map
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // populate the adjacency map
        for (int[] e : edges) {
            if (!adj.containsKey(e[0])) {
                adj.put(e[0], new ArrayList<>());
            }
            if (!adj.containsKey(e[1])) {
                adj.put(e[1], new ArrayList<>());
            }
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // call the dfs
        return dfs(adj, 0, -1, hasApple);
    }

    public int dfs(Map<Integer, List<Integer>> adj, int curr, int parent, List<Boolean> hasApple) {
        // we basically call the dfs for every child connected to our current node
        // then a particular child becomes the current node, and the previous current node becomes the parent for that child
        // this goes on and from depth we keep getting the consumed time and come back to top

        int time = 0;   // variable to store the time consumed below our current node
        // check for every child that are connected to the current node
        for (int child : adj.get(curr)) {
            if (child == parent) {  // we don't want to go back to the parent node, we want to go down below
                continue;
            }
            // call the dfs for the child, current node becomes the new parent
            // it will fetch us the time if there is an apple down below our child
            int timeFromChild = dfs(adj, child, curr, hasApple);
            // timeFromChild > 0 means we found an apple below the child
            // hasApple if true at current child means apple is present at current child as well
            if (timeFromChild > 0 || hasApple.get(child)) {
                // so we add 2 (1 (going down) + 1 (coming back)) and timeFromChild (time taken to collect apples below child)
                // to the total time of our current node
                time += (2 + timeFromChild);
            }
        }

        // return the time taken
        return time;
    }
}

// TC: O(v + e), SC: O(v + e)




class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        return dfs(adj, 0, -1, hasApple);
    }

    public int dfs(List<Integer>[] adj, int curr, int parent, List<Boolean> hasApple) {
        int time = 0;
        for (int child : adj[curr]) {
            if (child == parent) {
                continue;
            }

            int timeFromChild = dfs(adj, child, curr, hasApple);
            if (timeFromChild > 0 || hasApple.get(child)) {
                time += (2 + timeFromChild);
            }
        }

        return time;
    }
}

// TC: O(v + e), SC: O(v + e)