// Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode build(int[] io, int ioStart, int ioEnd, int[] po, int poStart, int poEnd) {
        if (ioStart > ioEnd || poStart > poEnd) {
            return null;
        }

        TreeNode root = new TreeNode(po[poEnd]);
        int rootIdx = map.get(po[poEnd]);
        int numsAtLeft = rootIdx - ioStart;

        root.left = build(io, ioStart, rootIdx - 1, po, poStart, poStart + numsAtLeft - 1);
        root.right = build(io, rootIdx + 1, ioEnd, po, poStart + numsAtLeft, poEnd - 1);

        return root;
    }
}

// TC: O(n), SC: O(n)
