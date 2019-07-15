package PQ;

import Tree.ListNode;

import java.awt.*;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/9.
 */
public class mergeKsortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length
        ,(a,b)->(a.val - b.val)
        );

        for (ListNode list : lists){
            if (list!=null){
                pq.offer(list);
            }
        }
        while (!pq.isEmpty()){
            // 最小的
            ListNode temp = pq.poll();
            head.next = temp;
            if (temp.next!=null){
                pq.offer(temp.next);
            }
            head =head.next;
        }
        return dummy.next;
    }
}