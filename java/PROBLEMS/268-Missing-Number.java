// Problem: https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i] + 1) {
                return nums[i] + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(1)


// Better solution

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        for (int x : nums){
            sum -= x;
        }

        return sum;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public int missingNumber(int[] nums) {
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            ans ^= (i ^ nums[i]);
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)


// Cycle sort
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int correctIdx = nums[i];
            if (nums[i] < n && nums[i] != nums[correctIdx]) {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
            else i++;
        }

        for (int j = 0; j < n; j++) {
            if (j != nums[j]) {
                return j;
            }
        }

        return n;
    }
}

// O(n), SC: O(1)