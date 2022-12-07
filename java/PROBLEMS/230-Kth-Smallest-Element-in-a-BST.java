// Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        return list.get(k - 1);
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) return;

        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}

// TC: O(n), SC: O(n)


class Solution {
    private int index = 0, ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        index++;
        if (index == k) {
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }
}

// TC: O(n), SC: O(h) - recursion stack