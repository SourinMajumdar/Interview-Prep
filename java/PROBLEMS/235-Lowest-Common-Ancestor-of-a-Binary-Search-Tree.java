// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Solution: https://www.youtube.com/watch?v=cX_kPV_foZc

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int curr = root.val;

        if (p.val > curr && q.val > curr) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (p.val < curr && q.val < curr) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
}

// TC: O(n), SC: O(1)