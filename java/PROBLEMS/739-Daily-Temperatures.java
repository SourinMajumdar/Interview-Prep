// Link: https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int days = 0;
            for (int j = i; j < n; j++) {
                if (temperatures[i] >= temperatures[j]) {
                    days++;
                }
                else {
                    ans[i] = days;
                    break;
                }
            }
        }

        return ans;
    }
}

// TC: O(n ^ 2), SC: O(n)


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)