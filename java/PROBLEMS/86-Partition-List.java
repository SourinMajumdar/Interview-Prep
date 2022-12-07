// Link: https://leetcode.com/problems/partition-list/


class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode less = new ListNode();
        ListNode greater = new ListNode();
        ListNode lessHead = less, greaterHead = greater;

        while (head != null) {
            if (head.val < x) {
                lessHead.next = head;
                lessHead = lessHead.next;
            }
            else {
                greaterHead.next = head;
                greaterHead = greaterHead.next;
            }

            head = head.next;
        }

        lessHead.next = greater.next;
        greaterHead.next = null;

        return less.next;
    }
}

// TC: O(n), SC: O(1)