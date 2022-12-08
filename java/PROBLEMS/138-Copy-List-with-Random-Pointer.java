// Link: https://leetcode.com/problems/copy-list-with-random-pointer/description/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;

        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;

        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}

// TC: O(n) + O(n) => O(n)
// SC: O(n)




class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head, currNext = head;

        while (curr != null) {
            currNext = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = currNext;
            curr = currNext;
        }

        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node ans = new Node(-1);
        Node copyItr = ans;
        curr = head; currNext = head;

        while (curr != null) {
            currNext = currNext.next.next;
            copyItr.next = curr.next;
            curr.next = currNext;
            curr = curr.next;
            copyItr = copyItr.next;
        }

        return ans.next;
    }
}


// TC: O(n) + O(n) + O(n) => O(n)
// SC: O(1)