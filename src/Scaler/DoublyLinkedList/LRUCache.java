package Scaler.DoublyLinkedList;

import java.util.HashMap;

public class LRUCache {

    int value;
    int size = 0;
    DListNode head;
    DListNode tail = null;

    HashMap<Integer,DListNode> hm = new HashMap<>();

    public int get(int key) {

        return -1;
    }

    public void set(int key, int value) {

    }
}

