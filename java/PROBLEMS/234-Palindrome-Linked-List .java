// Link: https://leetcode.com/problems/palindrome-linked-list/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();    // Create an arraylist
        ListNode temp = head;
        
        while (temp != null) {      // Add all linkedlist values to the array list
            list.add(temp.val);
            temp = temp.next;
        }
        
        
        // then perform basic two pointer from both ends and approach towards the middle 
        // and compare the elements with each iteration
        
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++; j--;
        }
        
        return true;
    }
}

// TC: O(n) + O(n), SC: O(n)


// Optimised approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        slow.next = reverseHalf(slow.next);
        slow = slow.next;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    ListNode reverseHalf(ListNode head) {
        ListNode Prev = null;

        while (head != null) {
            ListNode Next = head.next;
            head.next = Prev;
            Prev = head;
            head = Next;
        }

        return Prev;
    }
}


/*

- TC:    O(n / 2)      +        O(n / 2)          +          O(n / 2)
      to find middle      to reverse right-half      to compare both halves

  =>     O(n) + O(n) + O(n)

- SC: O(1)

*/


class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode fast = head, slow = head;
        ListNode mid = null;

        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        mid.next = null;
        ListNode rev = reverse(slow);

        ListNode head1 = head, head2 = rev;

        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}



