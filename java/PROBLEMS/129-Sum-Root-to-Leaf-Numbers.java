// Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

// BFS
class Solution {
    public int sumNumbers(TreeNode root) {
        int totalSum = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                curr.left.val += curr.val * 10;
                q.offer(curr.left);
            }

            if (curr.right != null) {
                curr.right.val += curr.val * 10;
                q.offer(curr.right);
            }

            if (curr.left == null && curr.right == null) {
                totalSum += curr.val;
            }
        }

        return totalSum;
    }
}

// TC: O(n), SC: O(n)



// DFS
class Solution {
    private int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return totalSum;
    }

    public void dfs(TreeNode root, int currNum) {
        if (root == null) {
            return;
        }

        currNum = currNum * 10 + root.val;

        if (root.left == null && root.right == null) {
            totalSum += currNum;
        }

        dfs(root.left, currNum);
        dfs(root.right, currNum);
    }
}

// TC: O(n), SC: O(h)