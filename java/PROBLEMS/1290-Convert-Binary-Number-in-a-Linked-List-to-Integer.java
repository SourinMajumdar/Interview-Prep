// Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/

class Solution {
    public int getDecimalValue(ListNode head) {
        int n = 0;
        for (ListNode h = head; h != null; h = h.next) {
            n++;
        }

        int ans = 0;
        for (; head != null; head = head.next) {
            if (head.val == 1) {
                ans += Math.pow(2, n - 1);
            }
            n--;
        }

        return ans;
    }
}

// TC: O(2n), SC: O(1)

class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }

        return ans;
    }
}


// TC: O(n), SC: O(1)