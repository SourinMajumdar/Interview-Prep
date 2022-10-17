// Link: https://leetcode.com/problems/contains-duplicate-iii/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (Math.abs((long) (nums[i] - nums[j])) <= valueDiff
                        && j - i <= indexDiff) {
                    return true;
                }

        return false;
    }
}

// TC: O(n ^ 2), SC: O(1)

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int i = 0, j = 1;

        while(j < nums.length){
            int currValueDiff = Math.abs(nums[i] - nums[j]);
            int currIndexDiff = Math.abs(i - j);

            if (currValueDiff <= valueDiff && currIndexDiff <= indexDiff){
                return true;
            }

            else if(currIndexDiff == indexDiff || j == nums.length - 1){
                j = ++i;
            }

            j++;
        }

        return false;
    }
}

// TC: O(n ^ 2), SC

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            Long num = new Long(nums[i]);
            Long floor = set.floor(num);
            Long ceil = set.ceiling(num);

            if (floor != null && Math.abs(floor - num) <= valueDiff) {
                return true;
            }

            if (ceil != null && Math.abs(ceil - num) <= valueDiff) {
                return true;
            }

            set.add(num);

            if (set.size() > indexDiff) {
                set.remove(1L * nums[i - indexDiff]);
            }
        }

        return false;
    }
}

// TC: O(n * logk), SC: O(k)