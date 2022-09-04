// Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// Solution: https://www.youtube.com/watch?v=q_a6lpbKJdw&t=941s

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Tuple {
    int x;      // x coordinate
    int y;      // y coordinate
    TreeNode node;

    public Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list;
    }
}

// TC: O(n * logn) -> As we are using TreeMap and each operation in TreeMap takes logN time.
// SC: O(n) + O(n)