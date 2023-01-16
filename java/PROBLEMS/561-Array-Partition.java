// Link: https://leetcode.com/problems/array-partition/description/

/*
We will first sort the array.
Say our array is [1, 2, 3, 4, 5, 6].
The duos which will give us the optimal solution are [1, 2], [3, 4] and [5, 6].
So we iterate from index 0 (because we need the minimum of each duo) and add every alternate element (skipping the maximum of each duo).
*/

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }

        return ans;
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(1)