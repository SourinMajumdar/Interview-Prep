// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Solution: https://www.youtube.com/watch?v=Lhu3MsXZy-Q


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        if (size == 1 && n == 1) {
            head = null;
            return head;
        }

        int nthFromStart = size - n;

        if (nthFromStart == 0) {
            head = head.next;
            return head;
        }

        temp = head;
        int i = 1;
        while (i != nthFromStart) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;

        return head;
    }
}

// TC: O(n) + O(n) => O(n)
// SC: O(1)


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start, slow = start;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
}

// TC: O(n), SC: O(1)