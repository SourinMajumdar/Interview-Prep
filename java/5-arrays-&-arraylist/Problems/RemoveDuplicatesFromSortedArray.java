// Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Solution: https://www.youtube.com/watch?v=Fm_p9lJ4Z_8

// Same logic but a bit different from each other

class Solution {
    public int removeDuplicates(int[] nums) {
        int firstPtr = 0;
        int secondPtr = 1;

        while(secondPtr < nums.length){
            if(nums[firstPtr] != nums[secondPtr]){
                firstPtr++;
                nums[firstPtr] = nums[secondPtr];
            }
            else{
                secondPtr++;
            }
        }

        return firstPtr + 1;

    }
}

// ==================================================

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j=1; j<nums.length; ++j){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;

    }
}


// TC: O(N), SC: O(1)