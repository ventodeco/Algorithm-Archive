class LRUCache {
    
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private Integer capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        cache = new HashMap<>();
        this.capacity = capacity;
        
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (! cache.containsKey(key)) {
            return -1;
        }
        
        Node node = cache.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        if (cache.size() == capacity) {
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }
    
    private void remove(Node node) {

        cache.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node) {

        cache.put(node.key, node);
        
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */