// Link: https://leetcode.com/problems/broken-calculator/description/

class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) {
            return startValue - target;
        }

        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        }

        return 1 + brokenCalc(startValue, target + 1);
    }
}

// TC: O(log(target)), SC: O(1)



class Solution {
    public int brokenCalc(int startValue, int target) {
        int result = 0;

        while (target > startValue) {
            result++;
            if (target % 2 == 0) target /=2;
            else target++;
        }

        return result + (startValue - target);


    }
}

// TC: O(log(target)), SC: O(1)