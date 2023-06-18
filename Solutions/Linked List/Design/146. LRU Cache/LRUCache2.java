import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    class Node {
        Node pre, next;
        int key, val;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = tail;

    }

    public int get(int key) {
        if (cache.get(key) != null) {
            Node node = cache.get(key);
            moveToHead(node);
            return node.val;

        }
        return -1;

    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LRUCache2.Node node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;

    }

    private void removeNode(LRUCache2.Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);

            size++;
            if (size > capacity) {
                Node curTail = removeCurTial();
                cache.remove(curTail.key);
                size--;
            }
        }
    }

    private LRUCache2.Node removeCurTial() {
        Node curTail = tail.pre;
        removeNode(curTail);
        return curTail;
    }
}
