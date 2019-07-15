package linkedList;

import Tree.ListNode;
import Tree.TreeNode;

/**
 * Created by yangw on 2019/7/13.
 */
public class covertSortedListToBST {
    ListNode current = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        current = head;
        int size = getSize(head);
        return helper(size);
    }

    private int getSize(ListNode head) {
        int length = 0;
        while (head!=null){
            length++;
            head = head.next;
        }
        return length;
    }

    private TreeNode helper(int size){
        if (size <= 0){
            return null;
        }

        TreeNode left = helper(size/2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(size - 1 -size/2);
        root.left = left;
        root.right = right;

        return  root;
    }


}