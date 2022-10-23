// Link: https://leetcode.com/problems/determine-if-two-events-have-conflict/

// Weekly 316, 23 Oct 2022
// Q1

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int s1 = toHrs(event1[0]);
        int e1 = toHrs(event1[1]);
        int s2 = toHrs(event2[0]);
        int e2 = toHrs(event2[1]);

        return !(e2 < s1 || e1 < s2);
    }

    public int toHrs(String time) {
        return Integer.valueOf(time.replace(":", ""));
    }
}

// TC: O(1), SC: O(1)