// Link: https://leetcode.com/maximum-sum-of-distinct-subarrays-with-length-k/

// Weekly 318, 6 Nov 2022
// Q2


class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;

        while (j < nums.length) {
            sum += nums[j];

            if (!map.containsKey(nums[j])) {
                map.put(nums[j], j);
            }

            else {
                int a = map.get(nums[j]) + 1;

                while (i < a) {
                    sum -= nums[i];
                    map.remove(nums[i]);
                    i++;
                }

                map.put(nums[j], j);
            }

            if (j - i + 1 > k) {
                sum -= nums[i];
                map.remove(nums[i]);
                i++;
            }

            if (map.size() == k) maxSum = Math.max(maxSum, sum);
            j++;
        }

        return maxSum;
    }
}

// TC: O(n), SC: O(k)


// OR
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;

        while (j < nums.length) {
            sum += nums[j];

            while (map.containsKey(nums[j]) || j - i + 1 > k) {
                sum -= nums[i];
                map.remove(nums[i]);
                i++;
            }

            map.put(nums[j], j);

            if (map.size() == k) maxSum = Math.max(maxSum, sum);
            j++;
        }

        return maxSum;
    }
}
// TC: O(n), SC: O(k)


class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        int i = 0, j = 0;

        Set<Integer> set = new HashSet<>();

        while (j < nums.length) {
            sum += nums[j];
            while (i < j && (set.contains(nums[j]) || set.size() >= k)) {
                set.remove(nums[i]);
                sum -= nums[i++];
            }

            set.add(nums[j]);

            if (set.size() == k) maxSum = Math.max(maxSum, sum);
            j++;
        }

        return maxSum;
    }
}

// TC: O(n), SC: O(k)


class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        boolean[] freq = new boolean[100001];

        long sum  = 0, maxSum = 0;
        int i = 0, j = 0;

        while (j < nums.length) {
            sum += nums[j];

            while(freq[nums[j]] || j - i + 1 > k){
                freq[nums[i]] = false;
                sum -= nums[i];
                i++;
            }

            freq[nums[j]] = true;

            if (j - i + 1 == k) maxSum = Math.max(maxSum, sum);
            j++;
        }

        return maxSum;
    }
}

// TC: O(n), SC: O(1)