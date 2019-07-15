package linkedList;

import Tree.TreeNode;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/13.
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
    // stack 的做法更好理解，也就是用中序遍历，不断加到左子节点，然后连接即可。
    public Node bstToDoublyList(TreeNode root) {
//        if (root == null) return null;
//        Stack<TreeNode> stack = new Stack<>();
//        Node dummy = new Node(0);
//        Node head = dummy;
//        //标准中序写法
//        while (!stack.isEmpty() && root!=null){
//            while (root!=null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            Node currentNode = new Node(root.val);
//            head.right = currentNode;
//            currentNode.left = head;
//            head = head.right;
//            root = root.right;
//        }
//        return dummy.right;

        // 建议用这种写法，比较稳
        if (root == null) return null;

        Stack<TreeNode> s = new Stack<>();
        Node dummy = new Node(0);
        Node dNode = dummy;
        s.push(root);
        while (!s.isEmpty()){
            while (root!=null && root.left!=null){
                s.push(root.left);
                root = root.left;
            }
            TreeNode cur = s.pop();
            Node curDnode = new Node(cur.val);
            dNode.right = curDnode;
            curDnode.left = dNode;
            dNode = dNode.right;

            cur = cur.right;
            if(cur!= null){
                s.push(cur);
            }
        }
        return dummy.right;
    }
    // 不太好理解的做法。 类似inorder
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
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
