// Link: https://leetcode.com/problems/separate-the-digits-in-an-array/description/

// biweekly 97, 4 Jan 2023
// Q1


class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            List<Integer> list = new ArrayList<>();
            while (i > 0) {
                list.add(0, i % 10);
                i /= 10;
            }
            ans.addAll(list);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}

// TC: O(n), SC: O(n)