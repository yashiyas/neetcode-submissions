class LRUCache {
    Map<Integer,Node> pairs;
    Node head;
    int capacity;
    Node tail;
    
    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.pairs = new HashMap();
        this.head = null;
        this.tail = null;
        
    }
    
    public int get(int key) {
        if(pairs.containsKey(key)){

            Node node = pairs.get(key);
            remove(node);
            add(node);
            return node.val;


        }
        return -1;
        
    }

    public void remove(Node node){
        if(node == head){
            head = node.next;
            node.next = null;
            if(head != null){
                head.prev = null;
            }
        }
        else if(node == tail){
            tail = node.prev;
            if(tail != null){
                tail.next = null;
            }
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

    }

    public void add(Node node){
        if(head == null){
            head = node;
            tail = node;
        }
        else
        {
            Node temp = tail;
            temp.next = node;
            node.prev = temp;
            tail = node;
        }
    }

    
    public void put(int key, int value) {
        Node node = new Node(key,value,null,null);
        if(pairs.containsKey(key)){
            Node curr = pairs.get(key);
            remove(curr);
            add(node);
        }
        else
        {
            if(pairs.size() == capacity){
                int k = head.key;
                remove(head);
                pairs.remove(k);
            }
        
            add(node);
        }
        pairs.put(key, node);
        

    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(){

        }

        Node(int key,int val, Node prev, Node next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
