// Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// https://www.youtube.com/watch?v=q4TO2ZfRnfk&list=PLMCXHnjXnTnsWU7jYp9XCKPW8ayl6D8fb&index=5

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node node = root;

        while (node.left != null) {
            Node curr = node;

            while (true) {
                curr.left.next = curr.right;

                if (curr.next == null) break;

                curr.right.next = curr.next.left;
                curr = curr.next;
            }

            node = node.left;
        }

        return root;
    }
}

// TC: o(n), SC:O(1)


// https://www.youtube.com/watch?v=KX6gz1-pjg0

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null && q.isEmpty()) {
                break;
            }

            if (curr == null) {
                q.add(null);
                continue;
            }

            curr.next = q.peek();

            if (curr.left != null)  q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }

        return root;
    }
}

// TC: O(n), SC: O(n)



class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            root.right.next = (root.next == null) ? null : root.next.left;
        }

        connect(root.left);
        connect(root.right);


        return root;
    }
}

// TC: O(n), SC: O(h)


