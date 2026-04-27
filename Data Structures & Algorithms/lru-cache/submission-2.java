class LRUCache {
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int k, int v){
            key = k;
            val = v;
            next = null;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
        this.capacity = capacity;
    }

    public void insert(Node node){
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }

        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);

        if(map.size() > capacity){
            Node lru = tail.prev;
            remove(lru);

            map.remove(lru.key);
        }
    }
}
