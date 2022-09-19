// Link: https://leetcode.com/problems/continuous-subarray-sum/
// Solution: https://www.youtube.com/watch?v=OKcrLfR-8mE

// Brute force (TLE)
// We check each and every subarray, and see if one of them satisfies the condition.
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        for (int i = 0; i < nums.length; ++i) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                sum += nums[j];
                if (sum % k == 0) return true;
            }
        }

        return false;
    }
}

// TC: O(n ^ 2), SC: O(1)


// useful discuss: https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space

/*

If we can find any two subarray of prefix sum having same mod value (or remainder), then their difference must be divisible by k.
So we can use a map to store mod value (or remainder) of each prefix sum in map, with its index.
Then check if map contains the same mod value (remainder) with index difference >= 2 when we have new mod value with each iteration.

 */

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;

        // Map<remainder, index>
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);     // Why? Find the answer below

        int currSum = 0;    // This would be our running sum

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int rem = 0;

            if (k != 0) rem = currSum % k;      // k can't be 0 when we do a number % k

            if (map.containsKey(rem)) {         // if that remainder already exists
                if (i - map.get(rem) > 1) {     // Length checking Step
                    return true;                // and if the diff between the indices of the same remainder > 1, we get our answer
                }
            }

            map.putIfAbsent(rem, i);            // else we put that remainder along with its index in the map

            // we don't do map.put(rem, i) because it'l' overwrite the old index (value) for the same rem (key).
            // using a 'putIfAbsent' will create a new unique map which we want.
        }

        return false;
    }
}

// Answer to why putting {0 : -1} in the map :
// we need to put a {0 : -1} in the map because what if at some point we get a remainder as 0?
// if we get a number divisible by k right at 0-th index, we won't return true because '0 - (-1) is not > 1' (Length/difference checking Step)
// and if we get a remainder as 0 later in the array we will be able to return true because 'x - (-1) > 0' when x >= 1. (where x is a latter index).
// As the logic suggests, keep going until you find the same remainder so we will need a 0 also for a 0 remainder which might come later.


// TC: O(n), SC: O(n)