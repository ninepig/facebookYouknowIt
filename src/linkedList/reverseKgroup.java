package linkedList;

import Tree.ListNode;

/**
 * Created by yangw on 2019/7/13.
 */
public class reverseKgroup {
    public ListNode reverseKgroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (true){
            cur = reverseK(cur,k);
            if (head == null)
                break;
        }
        return dummy.next;
    }
    // cur is the dummy node , it is the previous node of first targeted node
    private ListNode reverseK(ListNode cur, int k) {
        ListNode nk = cur;
        for (int i = 0 ; i < k ; i++){
            if (nk == null) return null;
            nk = nk.next;
        }
        // we just have k - 1 node
        if (nk == null) return  null;
        ListNode n1 = cur.next;
        ListNode nkNext = nk.next;

        // rev from n1 to
        ListNode pre = null;
        ListNode curNode = n1;
        while (curNode != nkNext){
            ListNode temp = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = temp;
        }

        // connect
        cur.next = nk;
        n1.next = nkNext;
        // n1 is the new head
        return n1;
    }

}