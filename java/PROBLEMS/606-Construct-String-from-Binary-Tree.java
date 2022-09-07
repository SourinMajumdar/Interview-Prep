// Link: https://leetcode.com/problems/construct-string-from-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    StringBuilder str = new StringBuilder();

    public String tree2str(TreeNode root) {
        construct(root);
        return str.toString();
    }

    public void construct(TreeNode root) {
        if (root == null) return;

        str.append(root.val);

        if (root.right == null && root.left == null) return;

        str.append("(");
        construct(root.left);
        str.append(")");

        if (root.right != null) {
            str.append("(");
            construct(root.right);
            str.append(")");
        }
    }
}

// TC: O(n) -> We visit every node once
// SC: O(h) -> h is the height of the recursive stack, in worst case h = n