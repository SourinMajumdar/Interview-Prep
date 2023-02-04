// Link: https://leetcode.com/problems/merge-nodes-in-between-zeros/

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode node = new ListNode(-1, null);
        ListNode h = node;
        head = head.next;
        while (head.next != null) {
            h.next = new ListNode(0, null);
            h = h.next;
            while (head.val == 0) {
                head = head.next;
            }
            while (head.val != 0) {
                h.val += head.val;
                head = head.next;
            }
        }

        return node.next;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode node = new ListNode(-1, null);
        ListNode n = node, h = head;

        while (h != null) {
            h = h.next;
            int sum = 0;
            while (h != null && h.val != 0) {
                sum += h.val;
                h = h.next;
            }
            if (sum != 0) {
                n.next = new ListNode(sum);
                n = n.next;
            }
        }

        return node.next;
    }
}

// TC: O(n), SC: O(1)