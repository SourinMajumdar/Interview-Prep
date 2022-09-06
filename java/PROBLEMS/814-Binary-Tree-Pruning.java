// link: https://leetcode.com/problems/binary-tree-pruning/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val != 1 && root.left == null && root.right == null) return null;

        return root;
    }
}

// TC: O(n) -> We visit every node once
// SC: O(n) -> Recursion stack can be as large as the height of the tree