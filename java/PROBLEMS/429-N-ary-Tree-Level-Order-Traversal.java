// Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
// Solution: https://www.youtube.com/watch?v=HlXRPDJ9jQc

/**
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
**/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> nodesAtLevel = new ArrayList<>();     // stores all node values at a particular level
            int size = q.size();

            while (size-- > 0) {
                Node current = q.poll();
                nodesAtLevel.add(current.val);                  // add the current node's value to the arraylist

                for (Node child : current.children) {           // add current node's children to the queue
                    q.add(child);
                }
            }

            result.add(nodesAtLevel);                           // add the value's arraylist of one whole level to result list
        }

        return result;
    }
}

// TC: O(n) -> We are visiting all the nodes
// SC: O(n) + O(n) => O(n)
// Queue can store nodes not more than n and result arraylist stores all the nodes in tree