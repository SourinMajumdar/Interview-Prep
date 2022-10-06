// Link: https://leetcode.com/problems/kth-distinct-string-in-an-array/


class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int count = 0;

        for (String s : arr) {
            if (map.get(s) == 1) {
                count++;
                if (count == k) return s;
            }
        }

        return "";
    }
}

// TC: O(n), SC: O(n)