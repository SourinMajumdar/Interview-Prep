// Link: https://leetcode.com/problems/path-sum/

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    boolean dfs(TreeNode node, int targetSum, int currSum) {
        if (node == null) return false;

        currSum += node.val;

        if (node.left == null && node.right == null) {
            if (currSum == targetSum) return true;
            return false;
        }

        boolean left  = dfs(node.left, targetSum, currSum);
        boolean right = dfs(node.right, targetSum, currSum);

        return left || right;
    }
}


// OR


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) return true;
            return false;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

// TC: O(n) - we visit every node of the tree
// SC: O(h) - where h is the height of the tree