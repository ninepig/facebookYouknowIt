package linkedList;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/13.
 */
public class copyWithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        HashMap<Node, Node> dict = new HashMap<>();
        Node dummy = new Node(0);
        Node pre = dummy;
        Node newHead = null;
        while (head != null){
            if (dict.containsKey(head)){
                newHead = dict.get(head);
            }else {
                newHead = new Node(head.val);
                dict.put(head, newHead);
            }

            if (head.random!=null){
                if (dict.containsKey(head.random)){
                    newHead.random = dict.get(head.random);
                }else {
                    newHead.random = new Node(head.random.val);
                    dict.put(head.random,newHead.random);
                }
            }
            pre.next = newHead;
            head = head.next;
            pre= pre.next;
        }
        return dummy.next;
    }

    public Node copyRandomListWithoutDict(Node head) {
        Node iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
    }
