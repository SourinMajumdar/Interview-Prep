// Link: https://leetcode.com/problems/add-one-row-to-tree/

// Solution: https://www.youtube.com/watch?v=ikbiEg7ShP0


// Breadth First Search
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        Queue<TreeNode> q = new LinkedList<>();
        depth--;
        q.offer(root);
        int level = 1;

        while (level != depth) {
            int size = q.size();
            level++;

            while (size-- > 0) {
                TreeNode head = q.poll();
                if (head.left != null) q.offer(head.left);
                if (head.right != null) q.offer(head.right);
            }
        }

        while (!q.isEmpty()) {
            TreeNode head = q.poll();

            TreeNode leftChild = head.left;
            TreeNode rightChild = head.right;

            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);

            head.left = newLeft;
            head.right = newRight;

            newLeft.left = leftChild;
            newRight.right = rightChild;
        }

        return root;
    }
}

// TC:
// Sc:
