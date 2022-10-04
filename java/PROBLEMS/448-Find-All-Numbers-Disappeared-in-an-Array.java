// Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int n : nums) set.add(n);

        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) ans.add(i);
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)


// No extra space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int n : nums) {
            nums[Math.abs(n) - 1] = -Math.abs(nums[Math.abs(n) - 1]);
        }

        List<Integer> ans = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }

        return ans;
    }
}