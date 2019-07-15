package Tree;

/**
 * Created by yangw on 2019/7/8.
 */
public class PopluatingNextRightPointer {
    /**
     * Definition for binary tree with next pointer.
     */
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    // 经典画图题
    public void connect(TreeLinkNode root){
        if (root == null) return;
        TreeLinkNode first = root;
        while (first != null){
            TreeLinkNode cur = first;
            while (cur!=null){
                if (cur.left!=null) cur.left.next = cur.right;
                if (cur.next != null && cur.right!=null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            // next level
            first = first.left;
        }
    }
}
