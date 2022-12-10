// Link: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
// https://www.youtube.com/watch?v=EVr0x96Wbec


class Solution {
    private long maxProduct = 0;
    private long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum(root);     // gets us the sum of all node values
        getMax(root);
        return (int) (maxProduct % 1000000007);
    }

    public long getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long left = getMax(root.left);
        long right = getMax(root.right);
        long currSubtreeSum = left + right + root.val;

        maxProduct = Math.max(maxProduct, currSubtreeSum * (totalSum - currSubtreeSum));

        return currSubtreeSum;
    }

    public void totalSum(TreeNode root) {
        if (root == null) {
            return;
        }

        totalSum += root.val;
        totalSum(root.left);
        totalSum(root.right);
    }
}

// TC: O(n) + O(n) => O(n)
// SC: O(h)