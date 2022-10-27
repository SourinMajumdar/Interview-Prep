// Link: https://leetcode.com/problems/symmetric-tree/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                if (curr == null) list.add(null);
                else {
                    list.add(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }

            if (!checkSymmetry(list)) return false;
        }

        return true;
    }

    public boolean checkSymmetry(List<Integer> list) {
        int l = 0, r = list.size() - 1;

        while (l < r) {
            if (list.get(l++) != list.get(r--)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(n)