// Problem: https://leetcode.com/problems/single-number/
// Solution:

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];

        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }

        return nums[nums.length - 1];
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(1)



// Using XOR
// 0^a = a
// a^b
// a^b^a = (a^a)^b = 0^b
// In this way only the number which is unique (lets say b) remains till the end
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) ans ^= n;
        return ans;
    }
}

// TC: O(n), SC: O(1)



class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {
            if (map.get(n) == 1) {
                return n;
            }
        }

        return 0;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) set.remove(n);
            else set.add(n);
        }

        return set.iterator().next();
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int n : nums) {
            if (list.contains(n)) {
                list.remove(Integer.valueOf(n));
            }
            else list.add(n);
        }

        return list.get(0);
    }
}

// TC: O(n ^ 2), SC: O(n)