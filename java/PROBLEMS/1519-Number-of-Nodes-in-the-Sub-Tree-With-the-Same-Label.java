// Link: https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/

class Solution {
    // globally declaring the ans array and adjacency list
    private int[] ans;
    private List<Integer>[] adj;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        adj = new List[n];               // initialising the adjacency list
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {          // populating the adjacency list
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        ans = new int[n];                // initialising the answer array
        dfs(0, -1, labels);    // calling the dfs
        return ans;
    }

    private int[] dfs(int curr, int parent, String labels) {
        // Our DFS will go to the depth and bring us frequencies of characters present present in subtrees, from bottom to top
        int[] currFreq = new int[26];   // records the frequency of all characters in the subtree
        for (int child : adj[curr]) {   // we look at all the nodes connected to our current node
            if (child == parent) {      // we don't want to go back to parent node where we came from
                continue;
            }
            // we now call dfs to record the frequency of all chacaters present below the child
            int[] freqBelow = dfs(child, curr, labels);     // new current is the child, new parent is our current
            // we update our currFreq array after we get freqBelow array populated
            for (int i = 0; i < 26; i++) {
                currFreq[i] += freqBelow[i];
            }
        }
        // the current node is also associated to a character so we update currFreq
        currFreq[labels.charAt(curr) - 'a']++;
        // now, currFreq contains the frequency of all characters present in subtree.
        // but now we just need the frequency of that particular character which is associated to our current node
        // say current node value is 1 and the letter associated is 'a'.
        // so we need the frequency of 'a's that have been found in the subtree
        ans[curr] = currFreq[labels.charAt(curr) - 'a'];
        return currFreq;    // we return the subtree frequency array which will be utilised upon backtracking
    }
}

// TC: O(e + v), SC: (e + v)