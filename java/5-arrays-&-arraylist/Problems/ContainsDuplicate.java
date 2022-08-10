// https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 1) {
            if(nums[i] == nums[i + 1]) return true;
            i++;
        }
        return false;

    }
}

// TC: O(n) + O(nlogn), SC: O(1)


// Using HashSet
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            map.add(num);
        }
        return false;
    }
}

// TC: O(n), SC: O(n)
// HashSet operations take constant time
