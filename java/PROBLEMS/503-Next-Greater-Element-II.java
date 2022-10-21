// Link: https://leetcode.com/problems/next-greater-element-ii/


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = -1;

            for (int j = 0; j < n; j++) {
                if (nums[(i + j) % n] > nums[i]) {
                    ans[i] = nums[(i + j) % n];
                    break;
                }
            }
        }

        return ans;
    }
}

// TC: O(n ^ 2), SC: O(n)



class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }

            if (i < n) stack.push(i);
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)