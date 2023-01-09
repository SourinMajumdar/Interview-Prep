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


// Iterative (Stack)
// add - right - left

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            ans.add(curr.val);

            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(h)

// TC: O(n), SC: O(h)