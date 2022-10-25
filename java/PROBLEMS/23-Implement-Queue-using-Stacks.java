// Link: https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {
    Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {   // O(n)
        if (s1.isEmpty()) s1.push(x);
        else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

// TC: O(n), SC: O(n)


class MyQueue {
    Stack<Integer> ip, op;

    public MyQueue() {
        ip = new Stack<>();
        op = new Stack<>();
    }

    public void push(int x) {
        ip.push(x);
    }

    public int pop() {
        if (op.isEmpty()) {
            while (!ip.isEmpty()) {
                op.push(ip.pop());
            }
        }

        return op.pop();
    }

    public int peek() {
        if (op.isEmpty()) {
            while (!ip.isEmpty()) {
                op.push(ip.pop());
            }

        }

        return op.peek();
    }

    public boolean empty() {
        return ip.isEmpty() && op.isEmpty();
    }
}


// TC: O(1) Amortised (Special case - O(n))
// SC: O(n)