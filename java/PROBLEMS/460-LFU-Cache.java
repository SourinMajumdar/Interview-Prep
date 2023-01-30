// Link: https://leetcode.com/problems/lfu-cache/


class LFUCache {
    private Map<Integer, Node> cache;
    private Map<Integer, List> freqMap;
    private int capacity, currSize, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateNode(node);
        } else {
            currSize++;
            if (currSize > capacity) {
                List minFreqList = freqMap.get(minFreq);
                Node LRU_Node = minFreqList.tail.prev;
                cache.remove(LRU_Node.key);
                minFreqList.removeFromList(LRU_Node);
                currSize--;
            }

            minFreq = 1;
            Node newNode = new Node(key, value);
            List minFreqList = freqMap.getOrDefault(1, new List());

            minFreqList.addToList(newNode);
            freqMap.put(1, minFreqList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(Node node) {
        int currFreq = node.freq;
        List currList = freqMap.get(currFreq);
        currList.removeFromList(node);

        if (currFreq == minFreq && currList.size == 0) {
            minFreq++;
        }

        node.freq++;
        List newList = freqMap.getOrDefault(node.freq, new List());
        newList.addToList(node);
        freqMap.put(node.freq, newList);
    }

    private class Node {
        int key, value, freq;
        Node next, prev;
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private class List {
        int size;
        Node head, tail;
        private List() {
            this.size = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void addToList(Node node) {
            Node headNext = head.next;
            head.next = node;
            node.next = headNext;
            headNext.prev = node;
            node.prev = head;
            size++;
        }

        private void removeFromList(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }
}

// TC: O(1), SC: O(n)