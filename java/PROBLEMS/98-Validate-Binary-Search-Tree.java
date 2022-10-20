// Link: https://leetcode.com/problems/validate-binary-search-tree/
// Solution: https://www.youtube.com/watch?v=f-sj7I5oXEI

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}

// TC: O(n), SC: O(h)