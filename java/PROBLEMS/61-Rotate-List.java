// Link: https://leetcode.com/problems/rotate-list/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        int size = 0;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

        k %= size;
        int count = 0;

        while (count++ != k) {
            curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }

            ListNode end = curr.next;
            curr.next = null;
            end.next = head;
            head = end;
        }

        return head;
    }
}

// TC: O(n) + O(n ^ 2) => O(n ^ 2)

// In case our k is greater than n,
// we mod k by n to make it less than n,
// so at max k can be n - 1
// So O(k * n) => O((n-1) * n) => O(n ^ 2)
// If we don't do it, we will get a TLE

// SC: O(1)



// https://www.youtube.com/watch?v=9VPm6nEbVPA


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode curr = head;
        int size = 1;

        while (curr.next != null) {
            size++;
            curr = curr.next;
        }

        curr.next = head;
        k %= size;
        k = size - k;
        // or k = size - (k % size);

        while (k-- > 0) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}


// TC: O(n) + O(n - k%n) => O(n)
// SC: O(1)