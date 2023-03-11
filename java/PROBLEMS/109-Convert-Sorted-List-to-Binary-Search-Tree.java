// Link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode slowPrev = null;
        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPrev.next = null;
        return slow;
    }
}

// TC: O(n.logn), SC: O(logn)