package linkedList;

import Tree.ListNode;

/**
 * Created by yangw on 2019/7/13.
 */
public class addTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return l1;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode head  = dummy;
        int carry = 0 ;
        while (l1 != null|| l2 != null){
            int sum = 0;
            if (l1 != null){
                sum += carry + l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += carry + l2.val;
                l2 = l2.next;
            }
            ListNode cur = new ListNode(sum%10);
            head.next = cur;
            carry = sum/10;
            head = head.next;
        }
        if(carry != 0){
            head.next = new ListNode(carry);
        }
        return dummy.next;
    }
}