// Link: https://leetcode.com/problems/remove-nodes-from-linked-list/

// weekly 321, 27 Nov 2022
// Q3

class Solution {
    public ListNode removeNodes(ListNode head) {
        head =  reverse(head);
        ListNode curr = head;

        while (curr.next != null){
            if (curr.next.val >= curr.val){
                curr = curr.next;
            }
            else curr.next = curr.next.next;
        }

        return reverse(head);
    }

    public ListNode reverse(ListNode head){
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