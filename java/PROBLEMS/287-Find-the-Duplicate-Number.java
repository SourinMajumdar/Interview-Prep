// Link: https://leetcode.com/problems/find-the-duplicate-number/
//

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans = nums[i];
            }
        }

        return ans;
    }
}

// TC: O(nlogn) + O(n), SC: O(1)


class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = nums[0];

        for (int num : nums) {
            if (set.contains(num)) {
                ans = num;
                break;
            }

            set.add(num);
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)


// Negative marking approach
class Solution {
    public int findDuplicate(int[] nums) {
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                ans = Math.abs(nums[i]);
                break;
            }

            nums[index] = - nums[index];
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)


// Floyd's cycle detection technique

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        fast = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

// TC: O(n), SC: O(1)
