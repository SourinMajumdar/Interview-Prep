// Link: https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
// https://www.youtube.com/watch?v=Vn-voe1XNtQ

// BFS

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);

        int minDistNode = -1;
        int minDistSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxDistBetweenTwo = Math.max(dist1[i], dist2[i]);
            if (maxDistBetweenTwo < minDistSoFar) {
                minDistSoFar = maxDistBetweenTwo;
                minDistNode = i;
            }
        }

        return minDistNode;
    }

    private void bfs(int[] edges, int currNode, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(currNode);

        boolean[] visited = new boolean[edges.length];
        visited[currNode] = true;

        dist[currNode] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            int nextNode = edges[curr];
            if (nextNode != -1 && !visited[nextNode]) {
                visited[nextNode] = true;
                dist[nextNode] = 1 + dist[curr];
                q.offer(nextNode);
            }
        }
    }
}

// TC: O(2n), SC: O(n)


// DFS

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];

        dist1[node1] = dist2[node2] = 0;

        dfs(edges, node1, dist1, vis1);
        dfs(edges, node2, dist2, vis2);

        int minDistNode = -1;
        int minDistSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxDistBetweenTwo = Math.max(dist1[i], dist2[i]);
            if (maxDistBetweenTwo < minDistSoFar) {
                minDistSoFar = maxDistBetweenTwo;
                minDistNode = i;
            }
        }

        return minDistNode;
    }

    private void dfs(int[] edges, int currNode, int[] dist, boolean[] visited) {
        visited[currNode] = true;
        int nextNode = edges[currNode];
        if (nextNode != -1 && !visited[nextNode]) {
            visited[nextNode] = true;
            dist[nextNode] = 1 + dist[currNode];
            dfs(edges, nextNode, dist, visited);
        }
    }
}

// TC: O(2n), SC: O(n)


// without boolean visited arrays

// DFS

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dist1[node1] = dist2[node2] = 0;

        dfs(edges, node1, dist1);
        dfs(edges, node2, dist2);

        int minDistNode = -1;
        int minDistSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxDistBetweenTwo = Math.max(dist1[i], dist2[i]);
            if (maxDistBetweenTwo < minDistSoFar) {
                minDistSoFar = maxDistBetweenTwo;
                minDistNode = i;
            }
        }

        return minDistNode;
    }

    private void dfs(int[] edges, int currNode, int[] dist) {
        int nextNode = edges[currNode];
        if (nextNode != -1 && dist[nextNode] == Integer.MAX_VALUE) {
            dist[nextNode] = 1 + dist[currNode];
            dfs(edges, nextNode, dist);
        }
    }
}


// BFS

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);

        int minDistNode = -1;
        int minDistSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxDistBetweenTwo = Math.max(dist1[i], dist2[i]);
            if (maxDistBetweenTwo < minDistSoFar) {
                minDistSoFar = maxDistBetweenTwo;
                minDistNode = i;
            }
        }

        return minDistNode;
    }

    private void bfs(int[] edges, int currNode, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(currNode);
        dist[currNode] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            int nextNode = edges[curr];
            if (nextNode != -1 && dist[nextNode] == Integer.MAX_VALUE) {
                dist[nextNode] = 1 + dist[curr];
                q.offer(nextNode);
            }
        }
    }
}

