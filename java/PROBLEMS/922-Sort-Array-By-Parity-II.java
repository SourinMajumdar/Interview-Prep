// Link: https://leetcode.com/problems/sort-array-by-parity-ii/

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        Stack<Integer> evens = new Stack<>();
        Stack<Integer> odds = new Stack<>();

        for (int n : nums) {
            if (n % 2 == 0) evens.add(n);
            else odds.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) nums[i] = evens.pop();
            else nums[i] = odds.pop();
        }

        return nums;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1;
        int n = nums.length;

        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) i += 2;
            while (j < n && nums[j] % 2 == 1) j += 2;

            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return nums;
    }
}

// TC: O(N), SC: O(1)