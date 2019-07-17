package fbMianjing;

import Tree.ListNode;

/**
 * Created by yangw on 2019/7/17.
 */
public class removeNthListNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null) return head;


        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 0 ; i < n ; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
