package linkedList;


import Tree.ListNode;

/**
 * Created by yangw on 2019/7/2.
 */
public class mergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return l1;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next =l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1!=null){
            head.next =l1;
        }
        if(l2!=null){
            head.next = l2;
        }

        return dummy.next;
    }
}
