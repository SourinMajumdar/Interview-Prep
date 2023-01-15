// Link: https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum/description/
// inspired: https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum/solutions/3052821/java-using-dfs-weighted-directed-tree-with-comments/?orderBy=most_votes
// my sol: https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum/solutions/3055069/java-dfs-explained/?orderBy=most_votes

// weekly 328, 15 Jan 2023
// Q4


class Solution {
    // globally declaring data structure to store the adjacency
    private Map<Integer, Long>[] adj;
    public long maxOutput(int n, int[][] edges, int[] price) {
        adj = new Map[n];   // initialising the adjacency map array
        for (int i = 0; i < n; i++) {
            adj[i] = new HashMap<>();
        }
        // populating the adjacency map array
        for (int[] e : edges) {
            adj[e[0]].put(e[1], 0L);
            adj[e[1]].put(e[0], 0L);
        }

        long maxDiff = 0;   // to store the maximum difference
        // for each node from 0 -> n-1, check the maximum achievable difference
        for (int i = 0; i < n; i++) {
            long currDiff = dfs(i, -1, price) - price[i];   // difference between path sum and node price
            // our dfs will give us the maximum achievable sum of all possible paths as i (node) as our endpoint
            maxDiff = Math.max(maxDiff, currDiff);
        }

        return maxDiff;     // return maximum difference
    }

    private long dfs(int currNode, int parent, int[] price) {
        long maxPathSum = 0;    // to store the maximum path sum achieved at current node
        // check for child nodes connected to our current node (child are stores a key in the map)
        for (int child : adj[currNode].keySet()) {
            if (child == parent) {  // we don't want to go back to our parent
                continue;           // so continue if condition is hit
            }
            // now we will check what is the maximum sum that has already been achieved at our child
            // map stores the node as key, and the maximum sum that is achievable at that node as an endpoint from every direction/path
            long maxSumFromChild = adj[currNode].get(child);
            if (maxSumFromChild == 0) {     // if that maximum child path sum was not already computed
                maxSumFromChild = dfs(child, currNode, price);  // we will computed it by calling dfs at that child node
                adj[currNode].put(child, maxSumFromChild);      // and we will put that maximum child sum by mapping it to the child node value
            }

            // Now we will update the maxPathSum (of our current node) with the max sum from our current child
            // this updation will be done after fetching max child path sum for each child
            maxPathSum = Math.max(maxPathSum, maxSumFromChild);
        }

        // finally we have the maximum acheivable child path sum from every child of our current node
        // so what is the max path sum for our current node?
        // it is the sum of the max child sum and price of our current node (which will be given by price[] array)
        return maxPathSum + price[currNode];    // return the maximum sum achieved from all directions as currentNode as our end point
        // it will also be utilised upon occasional backtracking (if child path sum is not already computed, dfs will be called otherwise not)
    }
}

// TC: O(2n), SC: O(2n)