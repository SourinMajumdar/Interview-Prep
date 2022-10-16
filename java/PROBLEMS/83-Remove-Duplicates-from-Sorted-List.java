// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode n = head;

        while (n != null && n.next != null) {
            if (n.val == n.next.val) {
                n.next = n.next.next;
            }
            else n = n.next;
        }

        return head;
    }
}

// TC: O(n), SC: O(1)


