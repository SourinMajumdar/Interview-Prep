// Link: https://leetcode.com/problems/online-stock-span/
// https://www.youtube.com/watch?v=vKPZNQjPsbA


class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[] {price, span});
        return span;
    }
}

// TC: O(n), SC: O(n)