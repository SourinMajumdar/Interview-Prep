// Link: https://leetcode.com/problems/minimum-penalty-for-a-shop/

// Biweekly 92, 26 November 2022
// Q2


class Solution {
    public int bestClosingTime(String customers) {
        int currPenalty = Integer.MAX_VALUE;
        int totalY = 0;

        for (int i = 0;  i < customers.length(); i++) {
            if (customers.charAt(i) ==  'Y') totalY++;
        }

        int currY = 0, currN = 0;
        int hour = 0;

        for (int i = 0; i < customers.length(); i++) {
            int newPenalty = totalY - currY + currN;

            if (newPenalty < currPenalty) {
                currPenalty = newPenalty;
                hour = i;
            }

            if (customers.charAt(i) == 'Y') currY++;
            else currN++;
        }

        int newPenalty = totalY - currY + currN;

        if (newPenalty < currPenalty) {
            currPenalty = newPenalty;
            hour = customers.length();
        }

        return hour;
    }
}

// TC: O(n), SC: O(1)