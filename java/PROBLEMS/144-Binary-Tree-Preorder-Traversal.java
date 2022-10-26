// Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
// Striver

// preorder traversal - root -> left -> right

// Recursive

class Solution {
    List<Integer> ans = new ArrayList<>()

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

// TC: O(n), SC: O(h)


// Iterative

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);

            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }

        return ans;
    }
}

// TC: O(n), SC: O(h)