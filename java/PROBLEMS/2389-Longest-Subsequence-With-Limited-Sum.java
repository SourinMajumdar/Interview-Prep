// Link: https://leetcode.com/problems/longest-subsequence-with-limited-sum/
// Solution: https://www.youtube.com/watch?v=vpWBTmazGjU

// Weekly 308, Question 1
// 28 August, 2022

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int len = n;
            for (int j = 0; j < n; j++) {
                if (nums[j] > queries[i]) {
                    len = j;
                    break;
                }
            }

            ans[i] = len;
        }

        return ans;
    }
}

// TC: O(n * logn) + O(n) + O(m * n)
// SC: O(m)



class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i + 1);
        }

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            Integer floor = map.floorKey(queries[i]);
            if (floor != null) {
                ans[i] = map.get(floor);
            }
        }

        return ans;
    }
}

// TC: O(n * logn) + O(n) + O(n * logn) + O(m * logn)
// SC: O(m + n)