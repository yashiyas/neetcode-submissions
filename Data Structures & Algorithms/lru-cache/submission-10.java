class LRUCache {

    int capacity;
    ListNode first;
    ListNode last;

    Map<Integer, ListNode> cache;



    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new HashMap();
        
    }
    
    public int get(int key) {

        if(cache.containsKey(key)){
            ListNode node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        if(!cache.containsKey(key)){
            ListNode node = new ListNode(value, key);
            if(cache.size() < capacity){
                add(node);
            }else{
                removeLast();
                add(node);
            }

            cache.put(key, node);
        }else{
            ListNode node = cache.get(key);
            node.val = value;
            remove(node);
            add(node);
        }
        
    }

    private void add(ListNode node){

        node.prev = null;

        if(first == null && last == null){
            first = node;
            last = node;
        }

        else{
            first.prev = node;
            node.next = first;
            first = node; 
        }
    }

    private void remove(ListNode node){
        ListNode tempPrev = node.prev;
        ListNode tempNext = node.next;

        node.prev = null;
        node.next = null;

        if(node == first && node == last){
            first = null;
            last = null;
        }else if(node == last){
            tempPrev.next = null;
            last = tempPrev;
        }else if (node == first){
            tempNext.prev = null;
            first = tempNext;
        }else{
            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;
        }
        
    }

    private void removeLast(){

        cache.remove(last.key);

        if(first == last){
            
            first = null;
            last = null;
        }
        else{

            ListNode node = last;
            ListNode temp = last.prev;
            temp.next = null;
            last = temp;
            node.prev = null;

        }
        
        
    }

    class ListNode{

        Integer val;
        Integer key;
        ListNode next;
        ListNode prev;

        ListNode(int val, int key){
            this.val = val;
            this.key = key;
        }

        ListNode(){
        }
    }
}
