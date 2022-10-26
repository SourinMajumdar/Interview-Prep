// Link : https://leetcode.com/problems/binary-tree-inorder-traversal/
// https://www.youtube.com/watch?v=lxTGsVXjwvM

// inorder traversal - left -> root -> right


// Iterative:
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;

            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }
}

// TC: O(n) -> We are traversing N nodes and every node is visited exactly once.
// SC: O(n) -> In the worst case (a tree with just left children), the space complexity will be O(n).


// Recursive:
class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        ans.add(node.val);
        traverse(node.right);
    }
}

// TC: O(n) -> We are traversing N nodes and every node is visited exactly once.
// SC: O(n) -> Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).