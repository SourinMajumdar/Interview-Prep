// Link: https://leetcode.com/problems/swap-nodes-in-pairs/description/


class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode dummyHead = dummy;
        ListNode a = head, b = head.next, c = head.next.next;

        while (true) {
            dummyHead.next = b;
            b.next = a;
            a.next = c;

            if (c == null || c.next == null) {
                break;
            }

            dummyHead = a;
            a = a.next;
            b = b.next.next.next;
            c = c.next.next;
        }

        return dummy.next;
    }
}

// TC: O(n), SC: O(1)