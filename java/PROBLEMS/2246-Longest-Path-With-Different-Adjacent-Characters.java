// Link: https://leetcode.com/problems/longest-path-with-different-adjacent-characters/description/
// https://www.youtube.com/watch?v=EA8dP63iVPk


class Solution {
    // globally declaring answer and adjacency list
    private int longestPath = 1;    // path is atleast going to be 1 unit long (a node itself)
    private List<Integer>[] adj;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        adj = new List[n];      // initialising the adjacency list
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {   // populating the adjacency list
            int u = i, v = parent[i];
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(0, -1, s);          // calling the dfs
        return longestPath;     // returning the longest path length found
    }

    private int dfs(int currentNode, int parent, String s) {
        // there can be multiple children paths
        // but only the longest two of them can combine along with the current node to form a single longest path
        // so we take two variables which will store the longest and second longest path lengths
        int maxLen = 0, secondMaxLen = 0;
        for (int child : adj[currentNode]) {    // look at all all the child nodes of the current node
            // we don't want to go back to the parent node so continue if condition is true
            if (child == parent) {
                continue;
            }

            // Now we call the dfs for our child node
            // child becomes the current node, current node becomes the parent of the child
            int maxLenFromChild = dfs(child, currentNode, s);

            // we want adjacent node characters to be different
            // in case they are equal, continue the loop
            // the reason we have called the dfs before is because
            // there still can be potential answers down below so we call the dfs anyway and it'll look for it
            // and if this next condition is true, we just discard the further comparisons of lengths
            // because the current node is not going to be a part of it
            if (s.charAt(child) == s.charAt(currentNode)) {
                continue;
            }

            // if the longest length we got from our child is greater than our max length
            // the child's max length becomes the so far discovered max length
            // and the previous max length becomes the second max
            if (maxLenFromChild > maxLen) {
                secondMaxLen = maxLen;
                maxLen = maxLenFromChild;
            }
            // else if the length obtained from child is smaller than max length
            // but greater than second max length, we update second max length
            else if (maxLenFromChild > secondMaxLen) {
                secondMaxLen = maxLenFromChild;
            }
        }

        // as previously discussed, two longest lengths under a node will combine along with the node itself
        // to form a subtree like path (a subtree with two branches/paths)
        // so maxLen + secondMaxLen + 1 (the current node itself)
        longestPath = Math.max(longestPath, maxLen + secondMaxLen + 1);     // we update the so far discovered longest path length
        // we return the max length of path + 1 (the current node itself) for utilisation upon backtracking
        // this max length is length of the path we are in right now
        return maxLen + 1;
    }
}


// TC: O(e + v), SC: O(e + v)