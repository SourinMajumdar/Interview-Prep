// Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> neg = new ArrayList<>(),
        pos = new ArrayList<>();

        for (int n : nums) {
            if (n > 0) pos.add(n);
            else neg.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) nums[i] = pos.remove(0);
            else nums[i] = neg.remove(0);
        }

        return nums;
    }
}

// TC: O(n) + O(n * n) => O(n ^ 2) - arraylist remove() takes O(n) complexity
// SC: O(n + n) => O(n)


// Solution: https://www.youtube.com/watch?v=mq7bQ7ubzXY

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int positiveIdx = 0, negativeIdx = 1;

        for (int n : nums) {
            if (n > 0) {
                ans[positiveIdx] = n;
                positiveIdx += 2;
            }
            else {
                ans[negativeIdx] = n;
                negativeIdx += 2;
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)