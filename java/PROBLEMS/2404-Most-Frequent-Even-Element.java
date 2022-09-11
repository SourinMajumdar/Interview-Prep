// Link: https://leetcode.com/problems/most-frequent-even-element/

// Weekly 310 - 11 September 2022
// Q1

class Solution {
    public int mostFrequentEven(int[] nums) {

        // Map of the even elements and their respective counts
        Map<Integer, Integer> map = new TreeMap<>();        // Keyset is sorted

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {                         // Putting only even values
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                maxCount = Math.max(maxCount, map.get(n));  // We keep calculating the maxCount of an even number here only instead of doing it separately (Otherwise it'd take extra time)
            }
        }

        if (map.isEmpty()) return -1;                       // if no even values, map would be empty

        int ans = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {             // if maxCount is found, we got the required key (other keys with same count would be greater because keyset is sorted)
                ans = entry.getKey();                       // save the key to ans
                break;                                      // break out
            }
        }

        return ans;
    }
}

// We can use a normal HashMap also but in that case we will have to iterate over the whole hashmap at the end to find our required key (even if we find it early), because hashmap is not sorted
// only after iterating the whole hashmap, we can return the minimum key as our answer. So by using a treemap, we somewhat reduce the execution time. As soon as the count is matched, we break out of the loop and return that particular key.

// TC: O(n) + O(n) + O(n) => O(n)
// SC: O(n)