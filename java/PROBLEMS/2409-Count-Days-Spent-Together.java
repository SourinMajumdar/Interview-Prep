// Link: https://leetcode.com/problems/count-days-spent-together/
// Solution: https://www.youtube.com/watch?v=WAcc4-Vcrys

class Solution {
    // Number of days in each month whichh will help us calculate n-th day in 0-365
    int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Returns the n-th day in (0-365) days of the year
    private int getNthDay(int month, int day) {
        int totalDays = 0;
        for (int i = 1; i < month; i++) {
            totalDays += monthDays[i];
        }

        totalDays += day;
        return totalDays;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        // We split the string and make an array as {"MM", "DD"} for Alice
        String[] aliceArr = arriveAlice.split("-");
        String[] aliceLea = leaveAlice.split("-");

        // We get the month and day when Alice arrived
        int aliceArriveMon = Integer.parseInt(aliceArr[0]);
        int aliceArriveDay = Integer.parseInt(aliceArr[1]);

        // We get the month and day when Alice left
        int aliceLeaveMon = Integer.parseInt(aliceLea[0]);
        int aliceLeaveDay = Integer.parseInt(aliceLea[1]);


        // We split the string and make an array as {"MM", "DD"} for Bob
        String[] bobArr = arriveBob.split("-");
        String[] bobLea = leaveBob.split("-");

        // We get the month and day when Bob arrived
        int bobArriveMon = Integer.parseInt(bobArr[0]);
        int bobArriveDay = Integer.parseInt(bobArr[1]);

        // We get the month and day when Alice left
        int bobLeaveMon = Integer.parseInt(bobLea[0]);
        int bobLeaveDay = Integer.parseInt(bobLea[1]);


        // We get the n-th day in 0-365 when Alice arrived and left
        int aliceArriveNthDay = getNthDay(aliceArriveMon, aliceArriveDay);
        int aliceLeaveNthDay = getNthDay(aliceLeaveMon, aliceLeaveDay);

        // We get the n-th day in 0-365 when Bob arrived and left
        int bobArriveNthDay = getNthDay(bobArriveMon, bobArriveDay);
        int bobLeaveNthDay = getNthDay(bobLeaveMon, bobLeaveDay);


        // We initialise a common day count
        int commonDays = 0;

        When i falls in their common staying range we increment ans
        for (int i = aliceArriveNthDay; i <= aliceLeaveNthDay; i++) {
            if (i >= bobArriveNthDay && i <= bobLeaveNthDay) commonDays++;
        }

        return ans;

        // int commonDays = Math.min(aliceLeaveNthDay, bobLeaveNthDay) - Math.max(aliceArriveNthDay, bobArriveNthDay) + 1;
        // return Math.max(commonDays, 0);
    }
}

// TC: 4 * O(12) + O(365) => O(1)
// SC: 4 * O(2) => O(1)