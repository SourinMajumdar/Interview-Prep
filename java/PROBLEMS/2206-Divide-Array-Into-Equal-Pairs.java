// Link: https://leetcode.com/problems/divide-array-into-equal-pairs/description/

class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, 1 + map.getOrDefault(i, 0));
        }

        for (int count : map.values()) {
            if (count % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}

class Solution {
    public boolean divideArray(int[] nums) {
        int[] f = new int[501];
        for (int i : nums) {
            f[i]++;
        }

        for (int i : nums) {
            if (f[i] % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}

class Solution {
    public boolean divideArray(int[] nums) {
        int num = 0;
        for (int i : nums){
            int ref = 1 << i;
            num ^= ref;
        }

        return num == 0;
    }
}