package enplee.algorithms_JAVA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public int capacity;
    public int size;
    public Map<Integer,LRUNode> map;
    public LRUNode head;
    public LRUNode trail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        head = new LRUNode();
        trail = new LRUNode();
        head.next = trail;
        trail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LRUNode temp = map.get(key);
            pop(temp);
            pushHead(temp);

            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            LRUNode temp = map.get(key);
            temp.value = value;
            pop(temp);
            pushHead(temp);
        }else {
            LRUNode temp = new LRUNode(key,value);
            map.put(key,temp);
            if(size<capacity){
                size++;
            }else {
                LRUNode del = trail.pre;
                pop(del);
                map.remove(del.key,del);
            }
            pushHead(temp);
        }
    }

    private void pop(LRUNode temp){
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
    }
    private void pushHead(LRUNode temp){
        head.next.pre = temp;
        temp.next = head.next;
        head.next = temp;
        temp.pre = head;
    }

    class LRUNode{
        int key;
        int value;
        LRUNode pre;
        LRUNode next;

        public LRUNode() {
        }

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
