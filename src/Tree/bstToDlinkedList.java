package Tree;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/8.
 */
public class bstToDlinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 这道题 preOrder的时候 stack 要不要加入cur.right的问题，只有preOrder 利用cur的时候才不需要加入cur.right
    // 这边肯定还有另外一种写法，也就是stack 用不用cur做判断
    public Node bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> s = new Stack<>();
        Node dummy = new Node(0);
        Node pre = dummy;
        TreeNode cur = root;
        while (!s.isEmpty()){
            while (root!=null && root.left!=null){
                s.push(root.left);
                root = root.left;
            }

            // 这个写法是精髓，归纳的时候要注意一下
            cur = s.pop();
            Node newNode = new Node(cur.val);
            pre.right = newNode;
            // 不能忘了和左侧相连
            newNode.left = pre;
            pre = pre.right;
            if (cur.right!=null){
                cur = cur.right;
                s.push(cur);
            }
        }
        return dummy.right;
    }



    Node prev = null;

    // 不太好理解的做法。
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        // 这个prev不应该是最右侧了么。而不是头部了
        //connect tail with head;
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(Node cur) {
        if (cur == null) {
            return;
        }
        helper(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        helper(cur.right);
    }
}
