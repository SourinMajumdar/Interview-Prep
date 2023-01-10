// Link: https://leetcode.com/problems/merge-k-sorted-lists/description/


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode h : lists) {
            while (h != null) {
                pq.offer(h.val);
                h = h.next;
            }
        }

        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while (!pq.isEmpty()) {
            head.next = new ListNode(pq.poll(), null);
            head = head.next;
        }

        return newList.next;
    }
}

// TC: O(m * n * log(mn))
// SC: O(m * n)