// Link: https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1


class Solution {
    public int KthSmallestElement(Node root, int K) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);

        if (K > list.size()) return -1;
        return list.get(K - 1);
    }

    private void inorder(List<Integer> list, Node root) {
        if (root == null) return;

        inorder(list, root.left);
        list.add(root.data);
        inorder(list, root.right);
    }
}

// TC: O(n), SC: O(n)


class Solution {
    private int index = 0, ans = -1;

    public int KthSmallestElement(Node root, int K) {
        inorder(root, K);
        return ans;
    }

    private void inorder(Node root, int  K) {
        if (root == null) return;

        inorder(root.left, K);

        index++;
        if (index == K) {
            ans = root.data;
            return;
        }

        inorder(root.right, K);
    }
}

// TC: O(n), SC: O(h) - recursion stack


