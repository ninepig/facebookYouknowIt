package linkedList;

import Tree.TreeNode;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/13.
 */
public class flattenTreeToList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            TreeNode cur = s.pop();
            if (cur.right!=null)  s.push(cur.right);
            if (cur.left!=null) s.push(cur.left);
            //connect
            cur.left = null;
            if (s.isEmpty()){
                cur.right = null;
            }else {
                cur.right = s.peek();
            }
        }
    }

    public void flattenTree(TreeNode root){
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return root;

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if(left != null){
            left.right = root.right;
            root.right = left;
            root.left = null;
        }
        if(right != null){
            return right;
        }
        if(left != null){
            return left;
        }
        return root;
    }
}
