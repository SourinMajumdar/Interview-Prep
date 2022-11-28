// Link: https://practice.geeksforgeeks.org/problems/maximum-sub-array5443/1
// https://www.youtube.com/watch?v=MKZ4bRq8Q14

class Solution {
    ArrayList<Integer> findSubarray(int a[], int n) {
        int maxSum = 0, currSum = 0;
        int maxStart = 0, maxEnd = 0, currStart = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                currSum = 0;
                currStart = i + 1;
            }
            else currSum += a[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                maxStart = currStart;
                maxEnd = i + 1;
            }
            else if (currSum == maxSum) {
                int currLen = i + 1 - currStart;
                int maxLen = maxEnd - maxStart;

                if (currLen > maxLen) {
                    maxStart = currStart;
                    maxEnd = i + 1;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = maxStart; i < maxEnd; i++) {
            ans.add(a[i]);
        }

        if (ans.isEmpty()) ans.add(-1);

        return ans;
    }
}

// TC: O(n), SC: O(n)