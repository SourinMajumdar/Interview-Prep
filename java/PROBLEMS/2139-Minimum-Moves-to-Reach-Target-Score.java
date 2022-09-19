// Link: https://leetcode.com/problems/minimum-moves-to-reach-target-score/

class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        if (maxDoubles == 0) return target - 1;

        while (target != 1) {
            if (target % 2 == 1) {
                target--;
                moves++;

            } else {
                if (maxDoubles-- > 0) {
                    target /= 2;
                    moves++;
                } else {
                    moves += target - 1;
                    break;
                }
            }
        }

        return moves;
    }
}

class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moveCount = 0;
        if (maxDoubles == 0) return target - 1;

        while (target != 1) {
            if (target % 2 == 0 && maxDoubles > 0) {
                target /= 2;
                maxDoubles--;

            } else if (maxDoubles == 0) {
                moveCount += target - 1;
                break;
            }

            else target--;  // target is odd
            moveCount++;
        }

        return moveCount;
    }
}


class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;

        while (target > 1 && maxDoubles > 0) {
            if (target % 2 != 0) {
                moves++;
            }

            maxDoubles--;
            target /= 2;
            moves++;
        }

        moves += target - 1;
        return moves;
    }
}

// TC: O(n), SC: O(1)

// Recursive
class Solution {
    public int minMoves(int target, int maxDoubles) {
        if (target == 1) return 0;
        if (maxDoubles == 0) return target - 1;

        if (target % 2 == 0) {
            return 1 + minMoves(target / 2, maxDoubles - 1);
        }
        // else
        return 2 + minMoves(target / 2, maxDoubles - 1);
    }
}

// TC: O(logn), SC: O(n)

