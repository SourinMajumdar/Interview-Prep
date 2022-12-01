// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int i = 0;

        for (int key : map.keySet()) {
            nums[i] = key;

            if (map.get(key) < 2) i++;
            else {
                nums[i + 1] = key;
                i += 2;
            }
        }

        return i;
    }
}

// TC: O(n * logn), SC: O(n)


class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        int idx = 0;

        while (j < nums.length) {
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }

            nums[idx] = nums[i];

            if (j - i < 2) idx++;
            else {
                nums[idx + 1] = nums[i];
                idx += 2;
            }

            if (j < nums.length) i = j;
        }

        return idx;
    }
}

// TC: O(n), SC: O(1)