// Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Solution: https://www.youtube.com/watch?v=Fm_p9lJ4Z_8

// Same logic but a bit different from each other

class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1;

        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }

        return l + 1;
    }
}



class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;

        for (int r = 1; r < nums.length; r++){
            if (nums[l] != nums[r]){
                l++;
                nums[l] = nums[r];
            }
        }

        return l + 1;
    }
}



// TC: O(N), SC: O(1)