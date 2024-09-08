class LRUCache {

    private Map<Integer, Integer> map;
    private Deque<Integer> dataKeeper;
    private Integer capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        dataKeeper = new ArrayDeque<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }

        if (dataKeeper.peek() != key) {
            dataKeeper.remove(key);
            dataKeeper.addFirst(key);
        }

        return value;
    }

    public void put(int key, int value) {

        if (dataKeeper.isEmpty()) {
            dataKeeper.addFirst(key);
        } else if (map.containsKey(key) && dataKeeper.peek() != key) {
            dataKeeper.remove(key);
            dataKeeper.addFirst(key);
        } else if (! map.containsKey(key)) {
            dataKeeper.addFirst(key);
        }

        map.put(key, value);

        if (dataKeeper.size() > capacity) {
            map.remove(dataKeeper.pollLast());
        }        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */