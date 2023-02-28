// https://leetcode.com/problems/find-duplicate-subtrees/description/


class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "null,";
        }

        String left = dfs(root.left);
        String right = dfs(root.right);
        String curr = root.val + "," + left + right;
        map.put(curr, 1 + map.getOrDefault(curr, 0));
        if (map.get(curr) == 2) {
            ans.add(root);
        }
        return curr;
    }
}

// TC: O(n^2), SC: O(n^2)