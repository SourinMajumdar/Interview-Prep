// Link: https://leetcode.com/problems/keys-and-rooms/description/
// https://www.youtube.com/watch?v=IRZuPwau_M8



class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;

        Queue<Integer> q = new LinkedList<>();
        q.addAll(rooms.get(0));

        while (!q.isEmpty()) {
            int room = q.poll();
            if (!vis[room]) {
                vis[room] = true;
                q.addAll(rooms.get(room));
            }
        }

        for (boolean b : vis) {
            if (!b) return false;
        }

        return true;
    }
}

// TC: O(e + v), SC: O(e + v)
// e -> number of keys
// v -> number of vertices