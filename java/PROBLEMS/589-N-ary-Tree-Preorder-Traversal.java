// Link: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
// Solution: https://www.youtube.com/watch?v=DAIN1ZzvFeA&t=3s


// Iterative

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            ans.add(curr.val);

            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }

        return ans;
    }
}


// TC: O(n), SC: O(n)



// Recursive

class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return ans;
        helper(root);
        return ans;
    }

    public void helper(Node node) {
        if (node.children == null) return;
        ans.add(node.val);

        for (Node child : node.children) {
            helper(child);
        }
    }
}

// TC: O(n), SC: O(h)