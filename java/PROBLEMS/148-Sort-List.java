// Link: https://leetcode.com/problems/sort-list/

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        List<Integer> list = new ArrayList<>();
        ListNode n = head;

        while (n != null) {
            list.add(n.val);
            n = n.next;
        }

        Collections.sort(list, Collections.reverseOrder());

        ListNode newNode = new ListNode(-1);
        ListNode newHead = newNode;

        while (!list.isEmpty()) {
            int idx = list.size() - 1;
            newNode.next = new ListNode(list.remove(idx));
            newNode = newNode.next;
        }

        return newHead.next;
    }
}


// TC: O(n) + O(n * logn) + O(n ^ 2)
// SC: O(n)



class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        ListNode n = head;

        while (n != null) {
            pq.offer(n);
            n = n.next;
        }

        ListNode newNode = new ListNode();
        ListNode newHead = newNode;

        while (!pq.isEmpty()) {
            newNode.next = new ListNode(pq.poll().val);
            newNode = newNode.next;
        }

        return newHead.next;
    }
}

// TC: O(n * logn), SC: O(n)



// merge sort

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // find middle
        ListNode f = head, s = head;
        ListNode prev = null;

        while (f != null && f.next != null) {
            prev = s;
            s = s.next;
            f = f.next.next;
        }

        prev.next = null;

        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(s);

        return merge(leftHalf, rightHalf);
    }

    // 21. Merge Two Sorted Lists
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode newNode = new ListNode();
        ListNode newHead = newNode;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                newNode.next = head1;
                head1 = head1.next;
            }
            else {
                newNode.next = head2;
                head2 = head2.next;
            }

            newNode = newNode.next;
        }

        while (head1 != null) {
            newNode.next = head1;
            head1 = head1.next;
            newNode = newNode.next;
        }

        while (head2 != null) {
            newNode.next = head2;
            head2 = head2.next;
            newNode = newNode.next;
        }

        return newHead.next;
    }
}

// TC: O(n * logn), SC: O(1)
