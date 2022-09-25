// Link: https://leetcode.com/problems/sort-array-by-increasing-frequency/

/*
We create a frequency map as well as an arraylist to store the values in nums so that we can custom sort it.

We then sort the list in increasing order of map values (i.e. the frequency of nums elements).

If two or more values (frequencies) happens to be same, then we sort the elements itself in decreasing order. (Look at the example testcases for a better understanding).

We return the list by convertng it to an array.
 */


class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int n : nums) {                            // O(n)
            ans.add(n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Collections.sort(ans, (a, b) -> {               // O(n * logn)
            return map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b);
        });

        return ans.stream().mapToInt(i -> i).toArray(); // O(n)
    }
}

// TC: O(n * logn), SC: O(n)