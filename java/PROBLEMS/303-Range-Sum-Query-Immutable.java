// Link: https://leetcode.com/problems/range-sum-query-immutable/


class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}

// TC: O(n), SC: O(n)


class NumArray {

    private int[] arr;

    public NumArray(int[] nums) {
        this.arr = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }

        return sum;
    }
}

// TC: O(k * n), SC: O(n)
// let k be the number of calls made to sumRange()