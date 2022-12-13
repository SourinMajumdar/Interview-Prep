// Link: https://leetcode.com/problems/3sum-with-multiplicity/description/


class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        long ans = 0;

        for (int i = 0; i < n - 2; i++) {
            int sum = target - arr[i];
            int l = i + 1, r = n - 1;

            while (l < r) {
                if (arr[l] + arr[r] < sum) l++;
                else if (arr[l] + arr[r] > sum) r--;
                else {
                    int count1 = 1, count2 = 1;

                    if (arr[l] == arr[r]) {
                        int len = r - l + 1;
                        ans += (len * (len - 1) / 2);
                        break;
                    }

                    while (l < r && arr[l] == arr[l + 1]) {
                        count1++;
                        l++;
                    }

                    while (r > l && arr[r] == arr[r - 1]) {
                        count2++;
                        r--;
                    }

                    ans += (count1 * count2);
                    l++; r--;
                }
            }
        }

        return (int) (ans % 1000000007);
    }
}


// TC: O(n * logn) + O(n ^ 2) ~ O(n ^ 2)
// SC: O(1)