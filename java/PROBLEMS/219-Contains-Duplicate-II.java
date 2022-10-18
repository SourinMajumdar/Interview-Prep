// Link: https://leetcode.com/problems/contains-duplicate-ii/


// Brute
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (nums[i] == nums[j] && j - i <= k)
                    return true;

        return false;
    }
}

// TC: O(n ^ 2), SC: O(1)



class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }
}

// TC: O(n), SC: O(k)



class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}

// TC: O(n), SC: O(n)