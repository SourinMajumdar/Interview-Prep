// Link: https://leetcode.com/problems/lru-cache/
// https://www.youtube.com/watch?v=Xc4sICC8m4M


class LRUCache {
    // Create doubly linkedlist
    private Node head = new Node(0, 0);     // head node
    private Node tail = new Node(0, 0);     // tail node
    // create map to store the key and its node
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;   // globally storing the capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        // if key is not present, return -1
        if (!map.containsKey(key)) {
            return -1;
        }

        // otherwise, fetch the node mapped to the key
        Node node = map.get(key);
        // we will set the node as the most recently used
        // by placing it right next to head
        remove(node);       // remove from wherever it is (also from map)
        insert(node);       // put it right after head  (also add it to map)
        return node.value;  // return value for the key
    }

    public void put(int key, int value) {
        // if map contains the key, we will remove the node from the map
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        // if map size has reached max capacity, we will remove the
        // LEAST RECENTLY USED node that will be right before the tail of linkedlist
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        // we will insert the new node at head's next and put it in the map
        insert(new Node(key, value));
    }

    // This method removes the node from its current position
    // as well as it removes the mapping from the hashmap
    private void remove(Node node) {
        // remove from map
        map.remove(node.key);
        // delete the node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // This method adds the node right at the next of the head
    // as well as it puts a new mapping into the hashmap
    private void insert(Node node) {
        // add to hashmap
        map.put(node.key, node);
        // Place at head's next
        Node headNext = head.next;
        headNext.prev = node;
        node.next = headNext;
        head.next = node;
        headNext.prev = node;
        node.prev = head;
    }

    // The node class
    private class Node {
        Node next, prev;
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}