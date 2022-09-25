// Link: https://leetcode.com/problems/sort-the-people/

// Weekly 312, 25 September 2022
// Q1

/*
We use a treemap instead of a hashmap which automatically sorts the keys and we put Collections.reverseOrder() comparator for a non-increasing (descending) sort.

We iterate over both the arrays together and put the corresponding values as <k, v> pairs in the map.

Then we simply return the set of values from the map as an an array of string.

Our work was done right at the beginning when we created the treemap.
 */

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        return map.values().toArray(new String[0]);
    }
}

// TC: O(n + logn), SC: O(1)