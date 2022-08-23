// Link: https://leetcode.com/problems/middle-of-the-linked-list/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode ans;

        while (true) {
            if (fast.next == null) {
                ans = slow;
                break;
            } else if (fast.next.next == null) {
                ans = slow.next;
                break;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return ans;
    }
}

// OR

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

// TC: O(n/2) -> O(n) - Because only half iteration is done
// SC: O(1)