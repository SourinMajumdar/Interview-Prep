// Link: https://leetcode.com/problems/design-circular-queue/
// Solution: https://www.youtube.com/watch?v=5AVzXbriy8E

class MyCircularQueue {
    int F;      // front pointer
    int R;      // rear pointer
    boolean noElePresent;
    int[] cQueue = null;

    public MyCircularQueue(int k) {
        this.cQueue = new int[k];
        this.noElePresent = true;
        this.F = 0;
        this.R = 0;
    }

    // O(1)
    public boolean enQueue(int value) {
        if (isFull()) return false;

        noElePresent = false;
        cQueue[R] = value;
        R = (R + 1) % cQueue.length;
        return true;
    }

    // O(1)
    public boolean deQueue() {
        if (isEmpty()) return false;

        F = (F + 1) % cQueue.length;
        if (R == F) noElePresent = true;
        return true;
    }

    // O(1)
    public int Front() {
        return isEmpty() ? -1 : cQueue[F];
    }

    // O(1)
    public int Rear() {
        if (isEmpty()) return -1;
        return R == 0 ? cQueue[cQueue.length - 1] : cQueue[R - 1];
    }

    // O(1)
    public boolean isEmpty() {
        return noElePresent;
    }

    // O(1)
    public boolean isFull() {
        return R == F && !noElePresent; // or !this.isEmpty()
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */


// TC: O(1), SC: O(k)