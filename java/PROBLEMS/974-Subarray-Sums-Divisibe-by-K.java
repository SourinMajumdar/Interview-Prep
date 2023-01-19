// Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/
// Solution: https://www.youtube.com/watch?v=QM0klnvTQzk

// Brute force
// check every possible subarray
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    total++;
                }
            }
        }

        return total;
    }
}

// O(n ^ 2), SC: O(1)

// Optimal
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // map to store the remainders and number of times they've been encountered
        Map<Integer, Integer> map = new HashMap<>();
        // our sum is initially 0, and 0 is also divisible by k
        // so we put <0, 1> initially
        map.put(0, 1);
        int runningSum = 0, ans = 0;
        for (int n : nums) {
            runningSum += n;            // add the element to the running sum
            int rem = runningSum % k;   // get the remainder by k of our running sum so far
            if (rem < 0) {              // in case remainder < 0,
                rem += k;               // add divisor (k) to make it +ve
            }
            // if we already encountered the remainder, we add the frequency mapped to it
            // that frequency is nothing but the number of subarrays whose sum has given that remainder
            ans += map.getOrDefault(rem, 0);
            // after that, we increment the frequency of that remainder,
            // because we have encountered it again so the number of subarrays increases by 1
            map.put(rem , 1 + map.getOrDefault(rem, 0));
        }

        return ans;     // return the answer
    }
}

// TC: O(n), SC: O(n)

