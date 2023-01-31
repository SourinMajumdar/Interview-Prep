// Link: https://leetcode.com/problems/design-circular-deque/description/

class MyCircularDeque {
    private int maxSize, currSize;
    private Node head, tail;

    public MyCircularDeque(int k) {
        this.maxSize = k;
        this.currSize = 0;
        head = tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int value) {
        if (currSize == maxSize) {
            return false;
        }

        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next.prev = newNode;
        currSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if (currSize == maxSize) {
            return false;
        }

        Node newNode = new Node(value);
        tail.prev.next = newNode;
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev = newNode;
        currSize++;
        return true;
    }

    public boolean deleteFront() {
        if (currSize == 0) {
            return false;
        }

        Node node = head.next;
        head.next = node.next;
        node.next.prev = node.prev;
        currSize--;
        return true;
    }

    public boolean deleteLast() {
        if (currSize == 0) {
            return false;
        }

        Node node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = node.next;
        currSize--;
        return true;
    }

    public int getFront() {
        return (currSize == 0)? -1 : head.next.value;
    }

    public int getRear() {
        return (currSize == 0)? -1 : tail.prev.value;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == maxSize;
    }

    private class Node {
        int value;
        Node next, prev;
        Node(int value) {
            this.value = value;
        }
    }
}