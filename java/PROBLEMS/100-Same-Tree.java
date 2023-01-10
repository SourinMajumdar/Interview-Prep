// Link: https://leetcode.com/problems/same-tree/description/

// do any type of traversal on both the trees and store it in lists
// check if the lists are equal
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();
        dfs(p, pList); dfs(q, qList);
        return pList.equals(qList);
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}

// TC: O(n), SC: O(n + h)


// Recursive
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // either one of them is null or both of them is
        if (p == null || q == null) {
            return p == q;
        }
        // check if values are equal
        if (p.val != q.val) {
            return false;
        }
        // call the functions for left and right subtrees
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;   // return what the subtrees return
    }
}

// TC: O(n), SC: O(h)


// iterative
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // condition checking for root nodes
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(p);
        st2.push(q);

        while (!st1.empty() && !st2.empty()) {
            TreeNode n1 = st1.pop();
            TreeNode n2 = st2.pop();

            // check if values are equal
            if (n1.val != n2.val) {
                return false;
            }
            // condition checking for children nodes
            if ((n1.left != null && n2.left == null) || (n1.left == null && n2.left != null)) {
                return false;
            }
            if ((n1.right != null && n2.right == null) || (n1.right == null && n2.right != null)) {
                return false;
            }

            // add the children to the stacks
            if (n1.left != null && n2.left != null) {
                st1.push(n1.left);
                st2.push(n2.left);
            }
            if (n1.right != null && n2.right != null) {
                st1.push(n1.right);
                st2.push(n2.right);
            }
        }

        // any dissimilarity if encountered above, would've returned false already
        // no dissimilarity encountered means trees are same, so return true
        return true;
    }
}

// TC: O(n), SC: O(n)