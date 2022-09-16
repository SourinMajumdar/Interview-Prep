// Link: https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] freq = new int[n + 1];
        int[] ans = new int[2];
        for (int i : arr) {
            freq[i]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (freq[i] == 0) ans[1] = i;
            if (freq[i] == 2) ans[0] = i;
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)


