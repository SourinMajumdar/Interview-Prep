// Link: https://leetcode.com/problems/count-nice-pairs-in-an-array/


class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for (int n : nums) {
            int key = n - reverse(n);

            if (map.containsKey(key)) {
                count += map.get(key);
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return (int) (count % 1000000007);
    }

    public int reverse(int n) {
        StringBuilder sb = new StringBuilder().append(n);
        return Integer.parseInt(sb.reverse().toString());
    }
}


// TC: O(n * k), SC: O(n)
// k -> number of digits in a number