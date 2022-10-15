// Link: https://leetcode.com/problems/merge-two-sorted-lists/

// SOlution: https://www.youtube.com/watch?v=Xb4slcp1U38


// Using extra space

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode();
        ListNode dummy = newNode;

        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                dummy.next = p1;
                p1 = p1.next;
            }
            else {
                dummy.next = p2;
                p2 = p2.next;
            }
            dummy = dummy.next;
        }

        while (p1 != null) {
            dummy.next = p1;
            dummy = dummy.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            dummy.next = p2;
            dummy = dummy.next;
            p2 = p2.next;
        }

        return newNode.next;
    }
}

// TC: O(m + n), SC : O(m + n)


// in place

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode res = list1;

        while (list1 != null && list2 != null) {
            ListNode tmp = null;

            while (list1 != null && list1.val <= list2.val) {
                tmp = list1;
                list1 = list1.next;
            }

            tmp.next = list2;

            // swap
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        return res;
    }
}

// TC: O(m + n), SC : O(1)