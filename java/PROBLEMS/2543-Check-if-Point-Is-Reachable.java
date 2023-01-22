// Link: https://leetcode.com/problems/check-if-point-is-reachable/description/

// biweekly 96, 22 Jan 2023
// Q4


class Solution {
    public boolean isReachable(int targetX, int targetY) {
        // if they are already (1, 1), then return true
        if (targetX == 1 && targetY == 1) {
            return true;
        }

        // keep reducing them unless they become odd
        while (targetX % 2 == 0) {
            targetX /= 2;
        }
        while (targetY % 2 == 0) {
            targetY /= 2;
        }
        // now reduce them by subtraction
        while (targetX >= 1 && targetY >= 1) {
            if (targetX > targetY) {
                targetX -= targetY;
            } else if (targetX < targetY) {
                targetY -= targetX;
            } else {
                // if they ever become equal it should be (1, 1)
                return targetX == 1 && targetY == 1;
            }
        }

        // iteration is over but they didn't become equal
        return false;
    }
}

//============================================================================

class Solution {
    public boolean isReachable(int targetX, int targetY) {
        while (targetX % 2 == 0) {
            targetX /= 2;
        }
        while (targetY % 2 == 0) {
            targetY /= 2;
        }

        return gcd(targetX, targetY) == 1;
    }

    public int gcd(int a, int b) {
        return b == 0? a : gcd(b, a % b);
    }
}


//============================================================================


class Solution {
    public boolean isReachable(int targetX, int targetY) {
        return help(targetX, targetY);
    }

    private boolean help(int x, int y) {
        if (x == 1 && y == 1) {
            return true;
        }
        if (x < 1 || y < 1) {
            return false;
        }
        if (x > y) {
            return (x % 2 == 0)?
            help(x / 2, y) : help(x - y, y);
        } else {
            return (y % 2 == 0)?
            help(x, y / 2) : help(x, y - x);
        }
    }
}