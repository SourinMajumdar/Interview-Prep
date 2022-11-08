// Link: https://leetcode.com/problems/find-lucky-integer-in-an-array/

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int max = -1;

        for (int n : map.keySet()) {
            if (n == map.get(n)) {
                max = Math.max(max, n);
            }
        }

        return max;
    }
}

// TC: O(n + k), SC: O(k)
// n -> length of arr
// k -> size of hashmap / number of unique elements


class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int n : arr) freq[n]++;

        int max = -1;

        for (int i = 1; i < 501; i++) {
            if (freq[i] == i) {
                max = Math.max(max, i);
            }
        }

        return max;
    }
}


// TC: O(n), SC: O(1)


