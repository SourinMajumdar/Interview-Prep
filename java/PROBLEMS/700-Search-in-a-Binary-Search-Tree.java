// Link: https://leetcode.com/problems/search-in-a-binary-search-tree/
// https://www.youtube.com/watch?v=KcNt6v_56cc

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;
        if (val < root.val) return searchBST(root.left, val);
        if (val > root.val) return searchBST(root.right, val);
        return root;
    }
}


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }
}