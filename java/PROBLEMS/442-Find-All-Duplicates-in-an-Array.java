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

// TC: O(n * logn) + O(n) ~ O(n * logn)
// SC: O(m) -> where m is the number of duplicates



class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }

        return ans;
    }
}

// TC: O(n), SC: O(m)


class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                ans.add(key);
            }
        }

        return ans;
    }
}

// TC: O(n + n) ~ O(n)
// SC: O(n + m)
// m be the number of duplicates


class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : nums) {
            if (map.get(n) == 1) {
                map.remove(n);
            }
        }

        return new ArrayList<>(map.keySet());
    }
}

// TC: O(n + n) ~ O(n)
// SC: O(n)


// cycle sort
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            }
            else i++;
        }

        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// TC: O(n) + O(n) ~ O(n)
// SC: O(1)