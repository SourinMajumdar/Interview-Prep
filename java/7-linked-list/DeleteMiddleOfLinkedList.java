// Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

class Solution {
    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null) return null;     // If single element

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {     // We find out the middle node
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = head;       // We make a new node
        while (temp.next != slow) {     // We move to the node just before the middle node
            temp = temp.next;
        }

        // We replace the middle node with the node next to the middle node

        temp.next = temp.next.next;

        // Middle node removed

        return head;
    }
}

/*

- TC:    O(n / 2)     +    O((n / 2) - 1)
      To find middle     To travel to mid-1

  =>     O(n) + O(n)

- SC: O(1)

*/