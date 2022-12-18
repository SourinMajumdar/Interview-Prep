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


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > st.peek().temp) {
                ans[st.peek().idx] = i - st.peek().idx;
                st.pop();
            }

            st.push(new Pair(temperatures[i], i));
        }

        return ans;
    }

    class Pair {
        int temp;
        int idx;

        Pair(int temp, int idx) {
            this.temp = temp;
            this.idx = idx;
        }
    }
}

// TC: O(n), SC: O(n)