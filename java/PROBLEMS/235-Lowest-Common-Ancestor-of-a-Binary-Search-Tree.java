// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Solution: https://www.youtube.com/watch?v=cX_kPV_foZc


// DFS
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


// BFS
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.offer(root);
        TreeNode result = null;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (p.val <= curr.val && q.val >= curr.val ||
                p.val >= curr.val && q.val <= curr.val) {
                return curr;
            }

            if (p.val > curr.val && q.val > curr.val) {
                if (curr.left != null) queue.offer(curr.right);
            }

            if (p.val < curr.val && q.val < curr.val) {
                if (curr.right != null) queue.offer(curr.left);
            }
        }

        return null;
    }
}

// TC: O(n), SC: O(n)