// Link: https://leetcode.com/problems/path-sum/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    boolean dfs(TreeNode node, int targetSum, int currSum) {
        if (node == null) return false;

        currSum += node.val;

        if (node.left == null && node.right == null) {
            return currSum == targetSum;
        }

        boolean left  = dfs(node.left, targetSum, currSum);
        boolean right = dfs(node.right, targetSum, currSum);

        return left || right;
    }
}


// OR


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

// TC: O(n) - we visit every node of the tree
// SC: O(h) - where h is the height of the tree




// BFS

//    We calculate prefix sum till each leaf node and the acquired prefix sum at each leaf node will be the path of the path traverse to reach that leaf node.
//    We store all such path sums in a hashset / arraylist.
//    At the end we check if target sum exists in the hashset / arraylist, and return true / false accordingly;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Set<Integer> allPathSums = new ArrayList<>();
        // List<Integer> allPathSums = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int i = q.size();

            while (i-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    curr.left.val = curr.left.val + curr.val;
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    curr.right.val = curr.right.val + curr.val;
                    q.add(curr.right);
                }

                // leaf
                if (curr.right == null && curr.left == null) {
                    allPathSums.add(curr.val);
                }
            }
        }

        return allPathSums.contains(targetSum);
    }
}


// TC: O(n * logn)

// SC:  O(n) + O(2^(h - 1))
//     queue     leaf set

// n is the number of nodes
// h is the height of tree

// at max a binary tree can can 2 ^ (height - 1) leaf nodes