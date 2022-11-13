// Link: https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/

// Weekly 319, 13 Nov 2022
// Q2

class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int currLcm = nums[i];

            for(int j = i; j < n; j++) {
                currLcm = lcm(currLcm, nums[j]);
                if (currLcm == k) ans++;
            }
        }

        return ans;
    }

    public int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;

        int absNumber1 = Math.abs(a);
        int absNumber2 = Math.abs(b);

        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);

        int lcm = absHigherNumber;

        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }

        return lcm;
    }
}

// TC: O(n ^ 2), SC: O(1)


class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int currLcm = nums[i];

            for(int j = i; j < n; j++) {
                currLcm = lcm(currLcm, nums[j]);
                if (currLcm == k) ans++;
            }
        }

        return ans;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}

// TC: O(n ^ 2), SC: O(1)