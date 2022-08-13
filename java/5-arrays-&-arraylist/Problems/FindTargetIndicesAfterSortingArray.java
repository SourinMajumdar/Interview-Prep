// Link: https://leetcode.com/problems/find-target-indices-after-sorting-array/


// 1. By sorting first
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }
        return ans;
    }
}

// TC: O(nlogn) + O(n); SC: O(n) in worst case


// 2. By not sorting

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int targetCount = 0, smallerElements = 0;
        
        
        // we count the number of times the target occurs
        // and the number of elements lesser than target
        for (int num : nums) {
            if (num == target) targetCount++;
            if (num < target) smallerElements++;
        }
        
        
        // If the array were sorted, the target would strart occupying indices from 
        // the number equal to smallerElements (coz 0-indexed) 
        // till (smallerElements + targetCount)
        // That would literally give us all the target indices serially
        
        for (int i = smallerElements; i < smallerElements + targetCount; i++) {
            ans.add(i);
        }
        
        return ans;
    }
}

// TC: O(n), SC: O(n) in worst case
