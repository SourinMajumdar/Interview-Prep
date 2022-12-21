// https://leetcode.com/problems/possible-bipartition/description/


class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : dislikes) {
            if (!map.containsKey(e[0])) {
                map.put(e[0], new ArrayList<>());
            }
            if (!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        int[] color = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                q.add(i);
                color[i] = 1;

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (map.get(curr) == null) {
                        continue;
                    }
                    for (int v : map.get(curr)) {
                        if (color[v] == 0) {
                            color[v] = -color[curr];
                            q.add(v);
                        }
                        else if (color[v] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

// TC: O(n + e), SC: O(n + e) + O(n) + O(n)


class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }

        List<Integer>[] list = new List[n + 1];
        for (int[] d : dislikes) {
            if (list[d[0]] == null) {
                list[d[0]] = new ArrayList<>();
            }
            if (list[d[1]] == null) {
                list[d[1]] = new ArrayList<>();
            }

            list[d[0]].add(d[1]);
            list[d[1]].add(d[0]);
        }

        int[] color = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                q.add(i);
                color[i] = 1;

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (list[curr] == null) {
                        continue;
                    }
                    for (int v : list[curr]) {
                        if (color[v] == 0) {
                            color[v] = -color[curr];
                            q.add(v);
                        }
                        else if (color[v] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

// TC: O(n + e), SC: O(n + e) + O(n) + O(n)