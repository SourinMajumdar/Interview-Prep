// Link: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

// Weekly 311, 18 September 2022
// Q3

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

// DFS
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        // We call the function from lvl 0, and everything starts from lvl 1
        traverse(root.left, root.right, 1);
        return root;
    }

    public void traverse(TreeNode node1, TreeNode node2, int lvl) {
        if (node1 == null || node2 == null) return;

        if (lvl % 2 == 1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        traverse(node1.left, node2.right, lvl + 1);
        traverse(node1.right, node2.left, lvl + 1);
    }
}

// TC: O(n) -> Every node in the binary tree is visited
// SC: O(h) -> where h is the height of the binary tree


// BFS
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            level++;

            if (level % 2 == 1 && !q.isEmpty()) {
                int[] nums = new int[q.size()];

                int i = 0;
                for (TreeNode node : q) {
                    nums[i++] = node.val;
                }

                int j = q.size() - 1;
                for (TreeNode node : q) {
                    node.val = nums[j--];
                }
            }
        }

        return root;
    }
}

// TC: O(n), SC: O(n)