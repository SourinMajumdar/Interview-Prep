// Link: https://leetcode.com/problems/all-paths-from-source-to-target/description/

// DFS
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[][] graph, List<Integer> path, int curr) {
        path.add(curr);
        if (curr == graph.length - 1) {
            ans.add(path);
            return;
        } else {
            for (int x : graph[curr]) {
                dfs(graph, new ArrayList<>(path), x);
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, new ArrayList<>(), 0);
        return ans;
    }
}

// TC: O(e + v), SC: O(e + v)



// BFS
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>(Arrays.asList(0)));

        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            int lastVertex = path.get(path.size() - 1);
            if (lastVertex == graph.length - 1) {
                ans.add(path);
            } else {
                for (int x : graph[lastVertex]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(x);
                    q.offer(newPath);
                }
            }
        }

        return ans;
    }
}

// TC: O(e + v), SC: O(e + v)