// Link: https://leetcode.com/problems/linked-list-cycle/

// using hashset

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode n = head;
        Set<ListNode> set = new HashSet<>();

        while (n != null) {
            if (set.contains(n)) return true;
            set.add(n);
            n = n.next;
        }

        return false;
    }
}

// TC: O(n), SC: O(n)

// Floyd's cycle detection technique

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }
}

// TC: O(n), SC: O(1)