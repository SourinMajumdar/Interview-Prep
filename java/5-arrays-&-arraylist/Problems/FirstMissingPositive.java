// Problem: https://leetcode.com/problems/first-missing-positive/
// Solution: https://www.youtube.com/watch?v=9SnkdYXNIzM

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;

        for (int ele : nums) {
            if(ele == min) {
                min++;
            }
        }
        return min;
    }
}

// TC: O(n) + O(n * logn) --> O(n * logn)
// SC: O(1)


class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int i = 1;
        while (set.contains(i)) i++;

        return i;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, containsOne = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) containsOne++;
            else if (nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }

        if (containsOne == 0) return 1;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = - nums[index];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;
    }
}

// TC: O(n), SC: O(1)

