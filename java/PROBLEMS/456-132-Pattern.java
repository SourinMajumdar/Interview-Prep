// Link: https://leetcode.com/problems/132-pattern/description/

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int secondMax = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < secondMax) {
                return true;
            }
            while (!st.isEmpty() && nums[i] > st.peek()) {
                secondMax = Math.max(secondMax, st.pop());
            }
            st.push(nums[i]);
        }

        return false;
    }
}

// TC: O(n), SC: O(n)