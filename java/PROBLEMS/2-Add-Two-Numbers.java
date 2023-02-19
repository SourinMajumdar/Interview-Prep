// Link: https://leetcode.com/problems/add-two-numbers/description/
// https://www.youtube.com/watch?v=LBVsXSMOIk4


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1), head = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
        }

        return ans.next;
    }
}

// TC: O(max(n1, n2))
// n1 -> length of l1, n2 -> length of l2

// SC: O(max(n1, n2)