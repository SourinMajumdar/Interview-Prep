// Link: https://leetcode.com/problems/longest-nice-subarray/

// Weekly 209, 4 september 2022
// Q3 

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLen = 1;

        for(int i = 0; i < nums.length - maxLen; i++) {
            int currLen = 1;
            int subarrayOR = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if ((subarrayOR & nums[j]) == 0) {
                    subarrayOR |= nums[j];
                    currLen++;
                }

                else break;
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}

// TC: O(n ^ 2), SC: O(1)



class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0,
            maxLen = 1, subarrayOR = 0;

        for (int i = 0; i < nums.length; i++) {

            while ((subarrayOR & nums[i]) != 0) {
                subarrayOR ^= nums[start++];    // a ^ (a|b|c|d) = 0|b|c|d = b|c|d
            }

            subarrayOR |= nums[i];

            int currLen = i - start + 1;
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}

// TC: O(n), SC: O(1)