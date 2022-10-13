// Link: https://leetcode.com/problems/design-linked-list/


// Using arraylist

class MyLinkedList {
    List<Integer> list;

    public MyLinkedList() {
        list = new ArrayList<>();
    }

    public int get(int index) {
        if (index >= list.size()) return -1;
        return list.get(index);
    }

    public void addAtHead(int val) {
        list.add(0, val);
    }

    public void addAtTail(int val) {
        list.add(list.size(), val);
    }

    public void addAtIndex(int index, int val) {
        if (index <= list.size()) {
            list.add(index, val);
        }
    }

    public void deleteAtIndex(int index) {
        if (index < list.size()) {
            list.remove(index);
        }
    }
}


// TC: O(n) + O(1) + O(n) + O(n) => O(n)
// SC: O(n)



// https://www.youtube.com/watch?v=yhsA4Vud_ms
// Using LinkedList
class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    int size;
    Node dummyNode;

    public MyLinkedList() {
        dummyNode = new Node(-1);
        size = 0;
    }

    public int get(int index) {
        if (index >= size) return -1;

        Node currNode = dummyNode;

        for (int i = 0; i <= index; i++) {
            currNode = currNode.next;
        }

        return currNode.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = dummyNode.next;
        dummyNode.next = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node currNode = dummyNode;

        for (int i = 0; i < size; i++) {
            currNode = currNode.next;
        }

        currNode.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;

        Node node = new Node(val);
        Node currNode = dummyNode;

        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }

        node.next = currNode.next;
        currNode.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;

        Node currNode = dummyNode;

        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }

        currNode.next = currNode.next.next;
        size--;
    }
}

// TC: 4 * O(n) => O(n)
// SC: O(n)
