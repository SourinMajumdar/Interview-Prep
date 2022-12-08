// Link: https://leetcode.com/problems/reverse-linked-list-ii/


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode curr = new ListNode(-1, head);
        ListNode ans = curr, prev = null, temp = head;

        for (int i = 1; i <= right; i++) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;

        for (int i = 1; i < left; i++) {
            curr = curr.next;
        }

        curr.next = reverse(curr.next);

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = temp;
        return ans.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

// TC: O(left + right) + O(right - left) => O(n) in worst case
// SC: O(1)