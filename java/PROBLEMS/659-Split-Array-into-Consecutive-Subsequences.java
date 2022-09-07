// Link: https://leetcode.com/problems/split-array-into-consecutive-subsequences/
// Solution: https://www.youtube.com/watch?v=Ty8EZlxVNC8&t=15s

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> avail = new HashMap<>();
        Map<Integer, Integer> vacant = new HashMap<>();

        for (int i : nums) {
            avail.put(i, avail.getOrDefault(i, 0) + 1);
        }

        for (int n : nums) {
            if (avail.get(n) <= 0) continue;

            else if (vacant.getOrDefault(n, 0) > 0) {
                avail.put(n, avail.getOrDefault(n, 0) - 1);
                vacant.put(n, vacant.getOrDefault(n, 0) - 1);
                vacant.put(n + 1, vacant.getOrDefault(n + 1, 0) + 1);

            } else if (avail.getOrDefault(n, 0) > 0 &&
                    avail.getOrDefault(n + 1, 0) > 0 &&
                    avail.getOrDefault(n + 2, 0) > 0) {

                avail.put(n, avail.getOrDefault(n, 0) - 1);
                avail.put(n + 1, avail.getOrDefault(n + 1, 0) - 1);
                avail.put(n + 2, avail.getOrDefault(n + 2, 0) - 1);

                vacant.put(n + 3, vacant.getOrDefault(n + 3, 0) + 1);

            } else return false;
        }

        return true;
    }
}

// TC: O(n), SC: O(n)