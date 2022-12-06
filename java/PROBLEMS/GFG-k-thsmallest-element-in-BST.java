// Link: https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

class Solution {
    public int KthSmallestElement(Node root, int K) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);

        if (K > list.size()) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i : list) {
            pq.offer(i);
            if (pq.size() > K) pq.poll();
        }

        return pq.poll();
    }

    private void inorder(List<Integer> list, Node root) {
        if (root == null) return;

        inorder(list, root.left);
        list.add(root.data);
        inorder(list, root.right);
    }
}

// TC: O(n) + O(n * logk)
// SC: O(n + k)


