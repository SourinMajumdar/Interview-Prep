// Link: https://leetcode.com/problems/count-complete-tree-nodes/

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

// TC: O(n), SC: O(n)



class Solution {
    public int countNodes(TreeNode root) {
        int sum = 1;
        if (root == null) return 0;

        if (root.left != null) {
            sum += countNodes(root.left);
        }
        if (root.right != null) {
            sum += countNodes(root.right);
        }

        return sum;
    }
}

// TC: O(n), SC: O(n)



class Solution {
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode node = q.poll();
                count++;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        return count;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if (lh == rh) return (2 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int leftHeight(TreeNode root) {
        int h = 0;
        while (root.left != null) {
            h++;
            root = root.left;
        }

        return h;
    }

    public int rightHeight(TreeNode root) {
        int h = 0;
        while (root.right != null) {
            h++;
            root = root.right;
        }

        return h;
    }
}

// TC: O(logn ^ 2), SC: O(logn)