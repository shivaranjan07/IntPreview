package lists;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    // initializ a <capacity> size data sctructure with two empty nodes pointing to each other (head and tail)
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    // move the current node to head, O(1)
    public void moveToHead(Node curr) {
        curr.next = head.next;
        curr.prev = head;
        head.next = curr;
        curr.next.prev = curr;
    }

    // delete the current node, O(1)
    public void delete(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    // when getting this node, delete it and move it to head because it is recently used, O(1)
    public int get(int key) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            delete(curr);
            moveToHead(curr);
            return curr.val;
        }
        return -1;
    }

    // puts a new node if it doesn't already exist. Regardless of if it already exists, this node is brough to head
    // because it is recently used. If capacity exceeds, remove the tail because it is the least used, O(1)
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            delete(curr);
            moveToHead(curr);
        }
        else if(map.size()<capacity) {
            map.put(key, new Node(key, value));
            moveToHead(map.get(key));
        }
        else {
            map.put(key, new Node(key, value));
            map.remove(tail.prev.key);
            delete(tail.prev);
            moveToHead(map.get(key));
        }
    }

    /**
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * Output
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     * */
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
        lru.get(2);
        lru.put(4,4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
    }

}


/**
 * Time: O(1) for everything
 * Space: O(capacity)
 *
 * Intuition:
 * 1. to ensure get operation is O(1), hashmap is used
 * 2. put at worst case involves, inserting new and deleting least recently used.
 *   - For inserting new, hashmap is also O(1)
 *   - For deleteing least recently used, the least recently used has to be tracked, so this involves keeping and
 *     modifying the ordering of the cached values. This is where doubly linked list can be used, where moving places,
 *     swapping or deletion are all O(1) when I can access each node through a hashmap
 */
