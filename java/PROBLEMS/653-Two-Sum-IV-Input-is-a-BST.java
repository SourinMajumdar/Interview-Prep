// Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

// Solution: https://www.youtube.com/watch?v=Rwu6cR9RZ6g

class Solution {
    List<Integer> nums = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int l = 0, r = nums.size() - 1;

        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum > k) r--;
            else if (sum < k) l++;
            else return true;
        }

        return false;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
}

// TC: O(n), SC: O(n)




class Solution {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return preorder(root, k);
    }

    public boolean preorder(TreeNode root, int k) {
        if (root == null) return false;

        int diff = k - root.val;
        if (set.contains(diff)) return true;

        set.add(root.val);
        return preorder(root.left, k) || preorder(root.right, k);
    }
}

// TC: O(n), SC: O(n)