// Link: https://leetcode.com/problems/count-number-of-nice-subarrays/

/*
We traverse the whole array and put 0 in place of even elements and 1 in place of odd elements.
So instead of finding k odd numbers, we now find subarrays whose sum will be equal to k (Because the odd numbers are all 1 and k odd numbers will give a sum of k now).

This takes us to the problem 560. Subarray Sum Equals K.

We can put 0s and 1s in place of even and odd number by simply iterating through the array.
*/

for (int i = 0; i < nums.length; i++) {
	nums[i] = (nums[i] % 2 == 0) ? 0 : 1;
}
/*

But that would take an extra O(n) time complexity.

So we won't do that. In Problem 560, we add nums[i] to sum at each iteration. So why not decide there itself whether to add 0 or 1 to sum!

Below is the solution, exactly similar to Problem 560.
 */



class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int total = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] % 2 == 0) ? 0 : 1;
            int rem = sum - k;

            if (map.containsKey(rem)) {
                total += map.get(rem);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}

// TC: O(n), SC: O(n)