// Link: https://practice.geeksforgeeks.org/problems/magic-triplets4003/1


class Solution{
    public int countTriplets(int[] nums){
        int n = nums.length;

        if (n < 3) return 0;

        int count = 0;

        for (int i = 0; i < n; i++) {
            int smaller = 0;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) smaller++;
            }

            int bigger = 0;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) bigger++;
            }

            count += smaller * bigger;
        }

        return count;
    }
}

// TC: O(n ^ 2), SC: O(1)