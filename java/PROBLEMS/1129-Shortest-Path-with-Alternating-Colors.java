// Link: https://leetcode.com/problems/shortest-path-with-alternating-colors/

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redAdj = buildAdj(redEdges, n);
        List<Integer>[] blueAdj = buildAdj(blueEdges, n);

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        boolean[] vRed = new boolean[n];
        boolean[] vBlue = new boolean[n];
        vRed[0] = vBlue[0] = true;

        Queue<Node> q = new LinkedList<>(); //{node, length, prev Edge Color}
        q.add(new Node(0, 0, "none"));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currNode = curr.node;
            int length = curr.length;
            String edgeColor = curr.colour;
            if (answer[currNode] == -1) {
                answer[currNode] = length;
            }

            if (!edgeColor.equals("red")) {
                for (int child : redAdj[currNode]) {
                    if (vRed[child]) {
                        continue;
                    }
                    vRed[child] = true;
                    q.add(new Node(child, length + 1, "red"));
                }
            }

            if (!edgeColor.equals("blue")) {
                for (int child : blueAdj[currNode]) {
                    if (vBlue[child]) {
                        continue;
                    }
                    vBlue[child] = true;
                    q.add(new Node(child, length + 1, "blue"));
                }
            }
        }

        return answer;
    }

    private List<Integer>[] buildAdj(int[][] edges, int n) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
        }

        return adj;
    }

    private class Node {
        int node, length;
        String colour;
        Node(int node, int length, String colour) {
            this.node = node;
            this.length = length;
            this.colour = colour;
        }
    }
}

// TC: O(n + e), SC: O(n + e) + O(3n)