// Link: https://leetcode.com/problems/brick-wall/
// https://www.youtube.com/watch?v=s4pN9Qfj8EY
// https://www.youtube.com/watch?v=bKt63YABdNw



class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxUntouched = 0;

        for (List<Integer> row : wall) {
            int brickEnd = 0;

            for (int i = 0; i < row.size() - 1; i++) {
                brickEnd += row.get(i);     // row.get(i) = brick size
                map.put(brickEnd, map.getOrDefault(brickEnd, 0) + 1);
                maxUntouched = Math.max(maxUntouched, map.get(brickEnd));
            }
        }

        return wall.size() - maxUntouched;
    }
}

// TC: O(m * n), O(n)
// m -> height of the wall
// n -> width of the wall
