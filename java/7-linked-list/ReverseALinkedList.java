// Link: https://leetcode.com/problems/reverse-linked-list/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode Next = head.next;
            head.next = newHead;
            newHead = head;
            head = Next;
        }

        return newHead;
    }
}

// TC: O(n), SC: O(1)


// Optimised approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        slow.next = reverseHalf(slow.next);
        slow = slow.next;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    ListNode reverseHalf(ListNode head) {
        ListNode Prev = null, Next = null;

        while (head != null) {
            Next = head.next;
            head.next = Prev;
            Prev = head;
            head = Next;
        }

        return Prev;
    }
}


/*

- TC:    O(n / 2)      +        O(n / 2)          +          O(n / 2)
      to find middle      to reverse right-half      to compare both halves

  =>     O(n) + O(n) + O(n)

- SC: O(1)

*/