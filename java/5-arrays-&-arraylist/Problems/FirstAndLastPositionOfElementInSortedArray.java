// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = giveIndex(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = giveIndex(nums, target, false);
        }
        
        return ans;
    }
    
    int giveIndex(int[] nums, int target, boolean findFirst) {
        int lo = 0, hi = nums.length - 1;
        int idx = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) lo = mid + 1;
            else {
                idx = mid;
                
                if (findFirst) hi = mid - 1;
                else lo = mid + 1;
            }
        }
        
        return idx;
    }
}

// TC: O(nlogn), SC: O(1)
