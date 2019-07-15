package design;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/11.
 */
public class LruCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer,Node> map;
    int capacity;
    Node head,tail;
    int count;
    
    public void put(int key, int value){
        if (map.get(key)!= null){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else {
            Node node = new Node(key,value);
            map.put(key,node);
            if (count < capacity){
                count++;
                addToHead(node);
            }else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }else {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
