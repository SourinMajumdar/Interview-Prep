// Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/


class Solution {
    public int pairSum(ListNode head) {
        if (head.next.next == null) return head.val + head.next.val;

        ListNode fast = head, slow = head, mid = null;

        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        mid.next = null;
        ListNode rev = reverse(slow);

        ListNode head1 = head, head2 = rev;
        int max = 0;

        while (head1 != null) {
            max = Math.max(head1.val + head2.val, max);
            head1 = head1.next;
            head2 = head2.next;
        }

        return max;
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

// TC: O(n), SC: O(1)




class Solution {
    public int pairSum(ListNode head) {
        if (head.next.next == null) return head.val + head.next.val;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> stack = new Stack<>();

        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        int max = 0;

        while (!stack.isEmpty()) {
            max = Math.max(head.val + stack.pop().val, max);
            head = head.next;
        }

        return max;
    }
}

// TC: O(n), SC: O(n)