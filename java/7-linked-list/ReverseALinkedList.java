// Link: https://leetcode.com/problems/reverse-linked-list/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode Prev = null;

        while (head != null) {
            ListNode Next = head.next;
            head.next = Prev;
            Prev = head;
            head = Next;
        }

        return Prev;
    }
}

// TC: O(n), SC: O(1)