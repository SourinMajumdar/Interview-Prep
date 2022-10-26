// Link: https://leetcode.com/problems/binary-tree-postorder-traversal/

// postorder traversal - left -> right -> root

class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        traverse(root.right);
        ans.add(root.val);
    }
}

// TC: O(n), SC: O(h)


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ans.add(curr.val);

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        Collections.reverse(ans);
        return ans;
    }
}

// TC: O(n), SC: O(n)



// We could do ans.add(0, curr.val) instead of Collections.reverse(ans) at the end.
// But adding at a specific index costs O(n) runtime.
// And doing that at every iteration is not wise according to me.
// So we add at the end of list at every iteration which costs O(1) and at the end we reverse the list which is O(n).
// So we do the O(n) operation one single time only.
