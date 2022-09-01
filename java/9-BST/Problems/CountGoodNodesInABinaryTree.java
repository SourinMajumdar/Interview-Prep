// Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// Solution: https://www.youtube.com/watch?v=7cp5imvDzl4

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) return 0;
        int res = root.val >= max ? 1 : 0;

        max = Math.max(max, root.val);
        res += dfs(root.left, max) + dfs(root.right, max);

        return res;
    }
}

// TC: O(n), SC: O(h)
// h -> height of binary tree