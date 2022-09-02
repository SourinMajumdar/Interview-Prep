// Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/
// Solution: https://www.youtube.com/watch?v=IVLrdahF9CM

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            result.add(sum / size);
        }

        return result;
    }
}

/*
TC: O(n) -> We must touch every single node a single time
Sc: O(n) -> In the worst case, queue might fill upto N nodes
*/