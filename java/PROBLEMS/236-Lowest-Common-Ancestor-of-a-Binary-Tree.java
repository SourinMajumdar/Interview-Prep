// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Solution: https://www.youtube.com/watch?v=_-QHfMDde90


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
}

// TC: O(n), SC: O(h)