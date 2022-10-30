// Link: https://leetcode.com/problems/find-mode-in-binary-search-tree/


class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root);

        int max = Collections.max(map.values());

        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                ans.add(key);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();

    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        dfs(root.left);
        dfs(root.right);
    }
}

// TC: O(n), SC: O(n)