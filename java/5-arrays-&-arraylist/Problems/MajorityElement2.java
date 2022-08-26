package Problems;// Link: https://leetcode.com/problems/majority-element-ii/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Integer i : count.keySet()) {
            if (count.get(i) > nums.length / 3) {
                ans.add(i);
            }
        }

        return ans;
    }
}

// TC: O(nlogn), SC: O(n)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1;
        int count1 = 0, count2 = 0;

        for (int n : nums) {
            if (n == num1) count1++;
            else if (n == num2) count2++;
            else if (count1 == 0) {
                num1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = count2 = 0;

        for (int n : nums) {
            if (n == num1) count1++;
            else if (n == num2) count2++;
        }

        if (count1 > nums.length / 3) ans.add(num1);
        if (count2 > nums.length / 3) ans.add(num2);

        return ans;
    }
}

// TC: O(n) + O(n), SC: O(1)