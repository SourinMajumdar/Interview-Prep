// Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/


class Solution {
    public int maxAncestorDiff(TreeNode root) {
        int max = -1, min = 100001;
        return findMaxDiff(root, max, min);
    }

    private int findMaxDiff(TreeNode root, int max, int min) {
        if (root == null) {
            return max - min;
        }

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        int left = findMaxDiff(root.left, max, min);
        int right = findMaxDiff(root.right, max, min);

        return Math.max(left, right);
    }
}

// TC: O(n), SC: O(h)