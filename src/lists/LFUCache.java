package lists;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    class Node {
        int key, value, frequency;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    class DLL {
        int listSize;
        Node head, tail;

        public DLL() {
            this.listSize = 0;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next =tail;
            tail.prev = head;
        }

        public void deleteNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            listSize--;
            printDLL(this.head);
        }

        public void addNode(Node node) {
            node.next = head.next;
            head.next = node;
            node.prev = head;
            node.next.prev = node;
            listSize++;
            printDLL(this.head);
        }
    }

    int capacity;
    int currentSize;
    int minimumFrequency;
    Map<Integer, Node> cache;
    Map<Integer, DLL> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.minimumFrequency = 0;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node curr = cache.get(key);
            updateNode(curr);
            return curr.value;
        }
        return -1;
    }

    public void updateNode(Node node) {
        int currentFrequency = node.frequency;
        DLL freqList = frequencyMap.get(currentFrequency);

        // deleteNode
        freqList.deleteNode(node);

        // if the list is Empty and nodes freq == minFreq, we need to update minFreq as node will go to next freq list
        if(currentFrequency == minimumFrequency && freqList.listSize == 0) {
            minimumFrequency++;
        }

        // moveToHead
        node.frequency++;
        DLL newList = frequencyMap.getOrDefault(node.frequency, new DLL());
        newList.addNode(node);
        frequencyMap.put(node.frequency, newList);
    }

    private void printDLL(Node head) {
        Node curr = head;
        System.out.print("[");
        while(curr != null){
            System.out.print(curr.value +" ");
            curr = curr.next;
        }
        System.out.print("]\n");
    }

    public void put(int key, int value) {
        if(capacity <= 0) return;

        if(cache.containsKey(key)) {
            Node curr = cache.get(key);
            curr.value = value;
            updateNode(curr);
        } else {
            currentSize++;
            if(currentSize > capacity) {
                DLL freqList = frequencyMap.get(minimumFrequency);
                cache.remove(freqList.tail.prev.key);
                freqList.deleteNode(freqList.tail.prev);
                currentSize--;
            }
            minimumFrequency = 1;
            Node newNode = new Node(key,value);
            DLL freqList = frequencyMap.getOrDefault(minimumFrequency, new DLL());
            freqList.addNode(newNode);
            frequencyMap.put(minimumFrequency, freqList);
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1,1);
        lfu.put(2,2);
        System.out.println(lfu.get(1));
        lfu.put(3,3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4,4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
    }
}

