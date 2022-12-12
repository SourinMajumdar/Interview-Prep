// Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// https://www.youtube.com/watch?v=WszrfSwMz58



class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSum(root, maxSum);
        return maxSum[0];
    }

    public int maxPathSum(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxPathSum(root.left, maxSum));
        int rightSum = Math.max(0, maxPathSum(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }
}

// TC: O(n), SC: O(h)