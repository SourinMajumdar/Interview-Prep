/*
Problem link: https://leetcode.com/problems/two-sum/

Solution link:
https://www.youtube.com/watch?v=uEdnIn9_Sdo&t=842s
https://www.youtube.com/watch?v=BoHO04xVeU0&t=449s

*/

// Brute force: O(N^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i=0; i<nums.length; ++i){
            for(int j=i+1; j<nums.length; ++j){
                if(nums[i]+nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }
}

// Optimised: O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans =  new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; ++i){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                ans[0] = map.get(complement);
                ans[1] = i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}