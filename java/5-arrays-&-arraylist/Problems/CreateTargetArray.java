/*
Problem link: https://leetcode.com/problems/create-target-array-in-the-given-order/
Solution: https://www.youtube.com/watch?v=vodPCmuIHc8
 */

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i<nums.length; ++i){
            arr.add(index[i], nums[i]);
        }

        for(int i = 0; i<nums.length; ++i){
            nums[i] = arr.get(i);
        }

        return nums;
    }
}

// TC: O(n^2), SC: O(n)