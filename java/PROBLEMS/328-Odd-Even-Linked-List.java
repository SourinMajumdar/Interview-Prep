// Link: https://leetcode.com/problems/odd-even-linked-list/


class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);

        ListNode oddHead = odd, evenHead = even;

        int i = 1;
        ListNode temp = head;

        while (temp != null) {
            if (i % 2 == 1) {
                oddHead.next = temp;
                oddHead = oddHead.next;
            }
            else {
                evenHead.next = temp;
                evenHead = evenHead.next;
            }

            temp = temp.next;
            i++;
        }

        evenHead.next = null;
        oddHead.next = even.next;

        return odd.next;
    }
}

// TC: O(n), SC: O(1)



class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head,
        even = head.next,
        temp = head.next.next;

        odd.next = null; even.next = null;

        ListNode prev = null,
        evenHead = even,
        oddHead = odd;

        int i = 1;
        while (temp != null) {
            prev = temp;

            if (i % 2 == 1) {
                oddHead.next = temp;
                oddHead = oddHead.next;
            }
            else {
                evenHead.next = temp;
                evenHead = evenHead.next;
            }

            temp = temp.next;
            prev.next = null;
            i++;
        }

        oddHead.next = even;
        return odd;
    }
}

// TC: O(n), SC: O(1)

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head,
                even = head.next,
                temp = head.next.next;

        odd.next = null; even.next = null;

        ListNode prev = null,
                evenHead = even,
                oddHead = odd;

        int i = 1;
        while (temp != null) {
            prev = temp;

            if (i % 2 == 1) {
                oddHead.next = temp;
                oddHead = oddHead.next;
            }
            else {
                evenHead.next = temp;
                evenHead = evenHead.next;
            }

            temp = temp.next;
            prev.next = null;
            i++;
        }

        oddHead.next = even;
        return odd;   // or head
    }
}

// TC: O(n), SC: O(1)