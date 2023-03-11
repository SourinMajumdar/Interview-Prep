// Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) {
            return new TreeNode(nums[l]);
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree(nums, l, mid - 1);
        root.right = buildTree(nums, mid + 1, r);

        return root;
    }
}

// TC: O(n.logn), SC: O(logn)