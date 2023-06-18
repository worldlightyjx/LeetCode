import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node{
        Node pre, next;
        int key, val;
        Node(){}
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int size;
    private int capacity;
    private Map<Integer,Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node==null){
            node = new Node(key,value);
            cache.put(key, node);
            addToHead(node);

            size++;
            if(size>capacity){
                Node curTail = removeCurrentTail();
                cache.remove(curTail.key);
                size--;
            }

        }else{
            node.val = value;
            moveToHead(node);
        }
    }

    private Node removeCurrentTail(){
        Node curTail = tail.pre;
        removeNode(curTail);
        return curTail;
    }


    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }


    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    private void addToHead(Node node){
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */