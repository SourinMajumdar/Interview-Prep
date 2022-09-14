// Link: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

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


// Solution: https://www.youtube.com/watch?v=GLK2g8dWlT8 (FRAZ)

class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        return dfs(root, freq);
    }

    public int dfs (TreeNode node, int[] freq) {
        if (node == null) return 0;

        // When we reach the leaf node, we'll have an array of counts of all numbers in that subtree
        if (node.left == null && node.right == null) {
            int c = 0;
            freq[node.val]++;

            // every number is should appear in pairs, or there should be only ONE ODD CASE

            for (int i : freq) {
                if (i % 2 == 1) c++;
            }

            freq[node.val]--;

            // leaving all other pairs, there should only be ONE case in which a number should appear only once and that'd go in the middle of the palindrome
            // If not, then its not a palindrome hence we don't count that subtree
            return c > 1 ? 0 : 1;
        }

        else {
            freq[node.val]++;
            int ans = dfs(node.left, freq) + dfs(node.right, freq);
            freq[node.val]--;
            return ans;
        }
    }
}

// TC: O(n) -> We visit every node of the tree
// Sc: O(h) -> where h  is the height of the tree


