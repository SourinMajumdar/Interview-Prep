// Link: https://leetcode.com/problems/sum-of-subarray-minimums/

// 77/87
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = j; k <= i; k++) {
                    min = Math.min(min, arr[k]);
                }

                sum += min;
            }
        }

        return (int) (sum % 1000000007);
    }
}

// TC: O(n ^ 3), SC: O(1)


// 84/87
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            sum += min;

            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }

        return (int) (sum % 1000000007);
    }
}

// TC: O(n ^ 2), SC: O(1)




class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;

        int[] leftMin = new int[n];
        Arrays.fill(leftMin, -1);

        int[] rightMin = new int[n];
        Arrays.fill(rightMin, n);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int index = stack.pop();
                rightMin[index] = i;
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                leftMin[index] = i;
            }

            stack.push(i);
        }

        stack.clear();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int leftLen = i - leftMin[i];
            int rightLen = rightMin[i] - i;
            ans = (ans + ((long) arr[i] * leftLen * rightLen) % mod) % mod;
        }

        return (int) ans;
    }
}