// Link: https://leetcode.com/problems/number-of-unequal-triplets-in-array/

// Weekly 320, 20 Nov 2022
// Q1


class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        Set<Integer> set;

        for (int i = 0; i < n; i++){
            set = new HashSet<>();
            set.add(nums[i]);

            for (int j = i + 1; j < n; j++){
                set.add(nums[j]);

                if (set.size() == 2) {
                    for (int k = j + 1; k < n; k++){
                        set.add(nums[k]);

                        if (set.size() == 3) {
                            count++;
                            set.remove(nums[k]);
                        }
                    }

                    set.remove(nums[j]);
                }

            }
        }

        return count;
    }
}

// TC: O(n ^ 3)
// SC: O(1) - because size of hashset is atmost 3



class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        count++;
                    }

        return count;
    }
}

// TC: O(n ^ 3), SC: O(1)


// https://leetcode.com/problems/number-of-unequal-triplets-in-array/discuss/2831702/O(n)
class Solution {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num , map.getOrDefault(num ,0)+1);
        }

        int left = 0, right = nums.length;
        int ans = 0;

        for (int key : map.keySet()){
            int count = map.get(key);
            right -= count;
            ans += left * count * right;
            left += count;
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)