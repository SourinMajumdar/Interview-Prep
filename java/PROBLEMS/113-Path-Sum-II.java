// Link : https://leetcode.com/problems/path-sum-ii/
// Solution: https://www.youtube.com/watch?v=3B5gnrwRmOA


class Solution {
    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPath(root, targetSum, new ArrayList<>());
        return paths;
    }

    void findPath(TreeNode node, int targetSum, List<Integer> current) {
        if (node == null) return;

        current.add(node.val);

        if (node.left == null && node.right == null && node.val == targetSum) {
            paths.add(current);
            return;
        }

        findPath(node.left, targetSum - node.val, new ArrayList<>(current));
        findPath(node.right, targetSum - node.val, new ArrayList<>(current));
    }
}

// TC: O(n) - We visit every node of the tree
// SC: O(h) - where h is the height of the tree