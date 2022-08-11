// Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/
// Solution: https://www.youtube.com/watch?v=lYxEdtR5_xQ

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}

// TC: O(nlogn) + O(n)



class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) ans.add(Math.abs(nums[i]));
            nums[index] = -nums[index];

        }
        return ans;
    }
}

// TC: O(N)



// Space Complexity: O(1)
// If you consider the result as extra space, it would be O(N).