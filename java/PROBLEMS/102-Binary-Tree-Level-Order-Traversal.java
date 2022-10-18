// Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
// Solution: https://www.youtube.com/watch?v=EoAsWbO7sqg

// iterative bfs
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int levelSize = q.size();

            while (levelSize-- > 0) {
                TreeNode curr = q.poll();
                currLevel.add(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            ans.add(currLevel);
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)


// recursive dfs

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return ans;
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level == ans.size()) ans.add(new ArrayList<>());
        ans.get(level).add(node.val);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}

// TC: O(n), SC: O(h)