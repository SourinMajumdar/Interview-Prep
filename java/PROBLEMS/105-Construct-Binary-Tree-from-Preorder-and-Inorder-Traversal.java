// Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class Solution {
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, n - 1, preorder, 0, n - 1);
    }

    private TreeNode build(int[] io, int ioStart, int ioEnd, int[] po, int poStart, int poEnd) {
        if (ioStart > ioEnd || poStart > poEnd) {
            return null;
        }

        TreeNode root = new TreeNode(po[poStart]);
        int rootIdx = map.get(po[poStart]);
        int numsAtLeft = rootIdx - ioStart;

        root.left = build(io, ioStart, rootIdx - 1, po, poStart + 1, poStart + numsAtLeft);
        root.right = build(io, rootIdx + 1, ioEnd, po, poStart + numsAtLeft + 1, poEnd);

        return root;
    }
}

// TC: O(n), SC: O(n)