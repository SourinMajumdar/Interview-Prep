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


class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode newNode = new ListNode(-1);
        ListNode newHead = newNode;

        while (!stack.isEmpty()) {
            newNode.next = new ListNode(stack.pop());
            newNode = newNode.next;
        }

        return newHead.next;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        ListNode current = head.next;
        current.next = head;
        head.next = null;

        return newHead;
    }
}

// TC: O(n), SC: O(n)