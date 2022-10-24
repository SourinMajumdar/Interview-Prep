// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> dup = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {
            if (!set.contains(temp.val)) {
                set.add(temp.val);
            }
            else dup.add(temp.val);
            temp = temp.next;
        }

        ListNode newNode = new ListNode(-1);
        ListNode newHead = newNode;
        temp = head;

        while (temp != null) {
            if (!dup.contains(temp.val)) {
                newNode.next = temp;
                newNode = newNode.next;
            }
            temp = temp.next;
        }

        newNode.next = null;
        return newHead.next;
    }
}

// TC: O(n), SC: O(n)



class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newNode = new ListNode(-1, head);
        ListNode prev = newNode;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            }
            else prev = prev.next;
            head = head.next;
        }

        return newNode.next;
    }
}

// TC: O(n), SC: O(1)