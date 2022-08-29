// Link: https://leetcode.com/problems/longest-consecutive-sequence/
// Solution: https://www.youtube.com/watch?v=qgizvmgeyUM

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int count = 0, maxCount = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] == nums[i]) continue;
            else if (nums[i + 1] != nums[i] + 1) count = 0;
            else{
                count++;
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount + 1;
    }
}

// TC: O(n * logn) + O(n) => O(n *logn)
// SC: O(1)


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int longestStreak = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }

                longestStreak = Math.max(longestStreak, currStreak);
            }
        }

        return longestStreak;
    }
}

// TC: O(n) + O(n) + O(n) => O(n)
// SC: O(1)