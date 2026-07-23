class LRUCache {

    class Node{
        int key, val;
        Node prev, next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    Map<Integer, Node> hash = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;
    }
    
    public int get(int key) {
        if(!hash.containsKey(key)) return -1;
        Node node = hash.get(key);
        delete(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hash.containsKey(key)){
            Node node = hash.get(key);
            node.val = value;
            delete(node);
            insert(node);
        }
        else{
            if(hash.size() == capacity){
                Node node = tail.prev;
                hash.remove(node.key);
                delete(node);
            }
            Node node = new Node(key, value);
            hash.put(key, node);
            insert(node);
        }
    }
    public void delete(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void insert(Node node){
        Node currHead = head.next;
        node.next = currHead;
        currHead.prev = node;
        head.next = node;
        node.prev = head;
    }
}
