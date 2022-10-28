// Link: https://leetcode.com/problems/invert-binary-tree/
// https://www.youtube.com/watch?v=NFt7yhEcsCs

// DFS

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // swap
        root.left = right;
        root.right = left;

        return root;
    }
}

// TC: O(n), SC: O(h)



// BFS

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            // remove
            TreeNode curr = q.poll();

            // swap
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // add children
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
        }

        return root;
    }
}

// TC: O(n), SC: O(n)
