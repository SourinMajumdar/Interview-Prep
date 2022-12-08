// Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head.next ==  null) return head;

        int kFromEnd = getSize(head) - k + 1;
        if (k == kFromEnd) return head;

        int idx = 1;
        ListNode node1 = head, node2 = null;

        while (idx != Math.max(kFromEnd, k)) {
            if (idx == Math.min(kFromEnd, k)) {
                node2 = node1;
            }
            node1 = node1.next;
            idx++;
        }

        // swap
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;

        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
}

// TC: O(n) + O(max(k, n-k+1))
// SC: O(1)





class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;

        ListNode slow = head, fast = head;
        ListNode node1 = null, node2 = null;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        node1 = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        node2 = slow;

        // swap
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;

        return head;
    }
}

// TC: O(k) + O(n - k) => O(n)
// SC: O(1)