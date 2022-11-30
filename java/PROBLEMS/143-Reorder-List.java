// Link: https://leetcode.com/problems/reorder-list/
// GFG link: https://practice.geeksforgeeks.org/problems/reorder-list/1


class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find middle node
        ListNode slow = head, fast = head;
        ListNode mid = slow;

        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        mid.next = null;                // free the original second half from original list
        ListNode rev = reverse(slow);   // reverse second half

        ListNode itr1 = head, itr2 = rev;

        // in place operation
        while (true) {
            ListNode temp1 = itr1.next;
            itr1.next = itr2;
            itr1 = temp1;

            ListNode temp2 = itr2.next;
            if (itr1 == null) break;

            itr2.next = itr1;
            itr2 = temp2;
        }
    }

    // reverse method
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        curr = head;
        int size = stack.size() / 2;

        while (size-- > 0) {
            ListNode top = stack.pop();
            ListNode temp = curr.next;

            curr.next = top;
            curr = temp;
            top.next = temp;
        }

        curr.next = null;
    }
}

// TC: O(n), SC: O(n)

