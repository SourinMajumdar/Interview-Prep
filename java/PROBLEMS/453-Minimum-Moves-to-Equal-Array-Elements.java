// Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

/*
To make elements equal, it means we need to make the difference between min element and max element in array equal to 0.
In each move, we can increase all n-1 elements by one. We should never choose to increase our max element, so we choose to increase other elements except our current max element, it means we decrease the difference between the max element and the min element by one.
So in each move, we need to decrease the current max element by one to util every elements become min element.
The problem become: count difference between other elements with our min element in the array.
For example: nums = [1, 2, 3]
Step 1, increase other elements except a maximum element 3, nums = [2, 3, 3]
Step 2, increase other elements except a maxium element, nums = [3, 4, 3].
Step 3, increase other elements except a maximum element, nums = [4, 4, 4].
 */

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
        }

        int ans = 0;
        for (int n : nums) {
            ans += (n - min);
        }

        return ans;
    }
}

// TC: O(2n), SC: O(1)


class Solution {
    public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int n : nums) {
            sum += n;
            min = Math.min(n, min);
        }

        return sum - min * nums.length;
    }
}

// TC: O(n), SC: O(1)