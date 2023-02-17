// Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

class Solution {
    // set initial values of minimum and previous node
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);   // go to left
        // if we have a previous node, we will get the difference
        if (prev != null) {
            int diff = Math.abs(prev.val - root.val);
            // update the minimum difference
            minDiff = Math.min(minDiff, diff);
        }
        // current node becomes the previous for the upcoming node
        prev = root;
        inorder(root.right);  // go to right
    }
}

// TC: O(n), SC: O(h)


class Solution {
    private List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i-1);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}

// TC: O(2n) => O(n)
// SC: O(n + h)
