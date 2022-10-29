// Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
// https://www.youtube.com/watch?v=FiFiNvM29ps

// iterative

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode n = root;

        while (true) {
            if (val < n.val) {
                if (n.left != null) n = n.left;
                else {
                    n.left = new TreeNode(val);
                    break;
                }
            }
            else {
                if (n.right != null) n = n.right;
                else {
                    n.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}

// TC: O(logn), SC: O(1)



// recursive

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}

// TC: O(h), SC: O(h)
// h -> height of the tree