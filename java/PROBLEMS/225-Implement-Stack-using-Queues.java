// Link: https://leetcode.com/problems/implement-stack-using-queues/
// https://www.youtube.com/watch?v=jDZQKzEtbYQ

// using 2 queues
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}


// using 1 queue
class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        int size = q.size();

        while (size-- > 1) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}