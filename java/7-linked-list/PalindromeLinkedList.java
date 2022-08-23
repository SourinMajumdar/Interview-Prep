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



