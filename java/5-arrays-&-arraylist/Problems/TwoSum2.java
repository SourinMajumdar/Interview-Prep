/*
Problem link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
Solution:
 */


// Two pointers - O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int low = 0, high = nums.length-1;
        while(low<=high){
            int sum = nums[low] + nums[high];
            if(sum > target){
                high--;
            }else if (sum < target) {
                low++;
            }else{  // sum = target
                arr[0] = low+1;
                arr[1] = high+1;
                break;
            }
        }
        return arr;
    }
}
