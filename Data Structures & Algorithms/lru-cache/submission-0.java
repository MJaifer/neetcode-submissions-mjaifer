class LRUCache {

    Node head, tail;
    Map<Integer, Node> map;
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        
        head = new Node(-1, -1); // dummy nodes
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (size == map.size()) {
            remove(tail.prev);
        }

        insert(node);
    }

    private void insert(Node node) {
        map.put(node.key, node);
        
        // connext head.next and currentNode
        node.next = head.next;
        head.next.prev = node;

        // connect head and current node
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    Node next;
    Node prev;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
