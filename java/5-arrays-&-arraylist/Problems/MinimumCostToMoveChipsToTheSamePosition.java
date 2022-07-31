// Problem: https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
// Solution: https://www.youtube.com/watch?v=XLzcIpfYeAI

/*
The intuition behind the solution is that we find the number of even positions and number of odd positions from the position array, and then return the minimum of the two. That minimum value will be the required cost.
If odd positions are more in number, then chips at odd positions can jump to other odd positions in multiples of two and save cost. Whereas a chip from even position at their last step will need to make -1 or +1 jump to get to a particular odd position where all chips are being piled up (No mattter how far they were, they can come to the pile's nearest position by -2/+2 jumps but at the end they have to take a +1/-1 step to make their position to odd from even). So, number of even positions = number of +1/-1 jump to change position from even to odd, So in this way, the minimum of odd and even positions give us the required cost.

Similary vice versa, if even positions are more in number, the chips at odd positions at the very end have to take a +1/-1 step to make their positions to even doing what they'll incur the cost.
 */

class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenPositions = 0, oddPositions = 0;

        for (int positionNumber : position) {
            if (positionNumber % 2 == 0) evenPositions++;
            else oddPositions++;
        }

        return Math.min(evenPositions, oddPositions);
    }
}