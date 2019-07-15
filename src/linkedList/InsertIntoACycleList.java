package linkedList;

/**
 * Created by yangw on 2019/7/13.
 */
public class InsertIntoACycleList {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }
    public Node insert(Node head, int insertVal) {
        if (head == null){
            Node newHead = new Node(insertVal,null);
            newHead.next = head;
            return newHead;
        }
        Node cur = head;
        while (true){
            if (cur.val < cur.next.val){
                // increasing phrase
                if (cur.val <= insertVal && insertVal<= cur.next.val){
                    cur.next = new Node(insertVal,cur.next);
                    break;
                }
            }else if (cur.val > cur.next.val){
                if (cur.val <= insertVal || insertVal <= cur.next.val){
                    cur.next = new Node(insertVal,cur.next);
                    break;
                }
            }else {
                // all node is same
                if (cur.next == head){
                    cur.next = new Node(insertVal,cur.next);
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
