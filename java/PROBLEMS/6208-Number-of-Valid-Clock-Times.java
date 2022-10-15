// Link: https://leetcode.com/problems/number-of-valid-clock-times/

class Solution {
    public int countTime(String time) {
        char[] Time = time.toCharArray();

        int hrs = 1;

        if (Time[0] == '?' && Time[1] == '?') {
            hrs = 24;
        }
        else if (Time[0] == '?' && Time[1] != '?') {
            if (Time[1] > '3') hrs = 2;
            else hrs = 3;
        }
        else if (Time[0] != '?' && Time[1] == '?') {
            if (Time[0] == '2') hrs = 4;
            else hrs = 10;
        }

        int mins = 1;

        if (Time[3] == '?' && Time[4] == '?') {
            mins *= 60;
        }
        else if (Time[3] == '?' && Time[4] != '?') {
            mins *= 6;
        }
        else if (Time[3] != '?' && Time[4] == '?') {
            mins *= 10;
        }

        return hrs * mins;
    }
}


class Solution {
    public int countTime(String time) {
        if (time.equals("??:??")) return 24 * 60;

        char[] t = time.toCharArray();
        int ans = 1;

        if (t[0] == '?' && t[1] == '?') ans *= 24;

        else if (t[0] == '?') {
            ans *= (t[1] > '3') ? 2 : 3;
        }

        else if (t[1] == '?') {
            ans *= (t[0] == '2') ? 4 : 10;
        }

        if (t[3] == '?') ans *= 6;
        if (t[4] == '?') ans *= 10;

        return ans;
    }
}


// TC: O(1), SC: O(n)