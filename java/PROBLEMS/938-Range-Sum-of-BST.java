// Link: https://leetcode.com/problems/range-sum-of-bst/
// https://www.youtube.com/watch?v=SIdrJwWp3H0


class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);

        int sum = 0;

        for (int i : list) {
            if (i >= low && i <= high) {
                sum += i;
            }
        }

        return sum;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) return;

        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}

// TC: O(n), SC: O(n)


// DFS
class Solution {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, high, low);
        return sum;
    }

    private void dfs(TreeNode root, int hi, int lo) {
        if (root == null) return;

        if (root.val >= lo && root.val <= hi) {
            sum += root.val;
        }

        dfs(root.left, hi, lo);
        dfs(root.right, hi, lo);
    }
}

// TC: O(n), SC: O(n)


// BFS
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.val >= low && curr.val <= high) {
                sum += curr.val;
            }

            if (curr.left != null && curr.val > low) {
                q.offer(curr.left);
            }

            if (curr.right != null && curr.val < high) {
                q.offer(curr.right);
            }
        }

        return sum;
    }
}


class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode curr = q.poll();

                if (curr.val >= low && curr.val <= high) {
                    sum += curr.val;
                }

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }

        return sum;
    }
}

// TC: O(n), SC: O(n)




