// Link: https://leetcode.com/problems/remove-linked-list-elements/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head, prev = dummy;

        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}

// TC: O(n), SC: O(1)


// Without using dummy node

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head != null && head.val == val) head = head.next;

        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.val == val) temp.next = temp.next.next;
            else temp = temp.next;
        }

        return head;
    }
}

// TC: O(n), SC: O(1)

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return (head.val == val) ? head.next : head;
    }
}

// TC: O(n), SC: O(n)


