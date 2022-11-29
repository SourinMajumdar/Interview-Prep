// Link: https://leetcode.com/problems/array-of-doubled-pairs/
// https://www.youtube.com/watch?v=tbq0fnZ-IhM

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {
            if (map.get(n) > 0) {
                if (n < 0 && n % 2 != 0) return false;

                int target = n < 0 ? n / 2 : n * 2;

                if (map.get(n) > map.getOrDefault(target, 0)) {
                    return false;
                }

                map.put(target, map.get(target) - map.get(n));
            }
        }

        return true;
    }
}

// TC: O(n * logn), SC: O(n)