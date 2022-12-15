// Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return ans;
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }
        if (level % 2 == 1) {
            ans.get(level).add(0, root.val);
        }
        else ans.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}

// TC: O(n * 2^(h - 1)/2), SC: O(n + h)
// h -> height of the binary tree


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int size = q.size();

            while (size-- > 0) {
                TreeNode curr = q.poll();
                currLevel.add(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            if (level % 2 == 1) {
                Collections.reverse(currLevel);
            }
            ans.add(currLevel);
            level++;
        }

        return ans;
    }
}

// TC: O(n * 2^(h - 1)/2), SC: O(n)
// h -> height of the binary tree