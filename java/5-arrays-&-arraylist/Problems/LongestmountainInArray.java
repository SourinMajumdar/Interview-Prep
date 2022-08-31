// Link: https://leetcode.com/problems/longest-mountain-in-array/solution/
// Solution: https://www.youtube.com/watch?v=h3st_zFMQNQ

class Solution {
    public int longestMountain(int[] arr) {
        // if (arr.length < 3) return 0;

        int maxLength = 0, i = 0;
        boolean uphill = false, downhill = false;

        while (i < arr.length - 1) {
            if (arr[i] < arr[i + 1]) {
                int start = i;

                while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                    i++;
                    uphill = true;
                }

                while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
                    i++;
                    downhill = true;
                }

                if (uphill && downhill) {
                    maxLength = Math.max(maxLength, i - start + 1);
                }

                uphill = downhill = false;
                
            } else {
                i++;
            }
        }

        return maxLength;
    }
}

// TC: O(n), SC: O(1)