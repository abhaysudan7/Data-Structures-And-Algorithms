package queue;

import java.util.HashMap;

/**
 * Solved using doubly linked-list to achieve tc = O(1)
 */
public class LRUCacheLC {
    Node head, tail;
    int capacity;
    HashMap<Integer, Node> map;

    public LRUCacheLC(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (capacity == map.size()) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    public static void main(String[] args) {
        LRUCacheLC lRUCache = new LRUCacheLC(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

