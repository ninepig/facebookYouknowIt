package Tree;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/8.
 */
public class flattenTreeToList {
    // Stack 的方法比较好理解， 就是push进去 然后popout出来 再连接
    public void flatten(TreeNode root){
        if (root == null) return ;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            // push right first, then left.
            if (cur.right != null) s.push(cur.right);
            if (cur.left != null) s.push(cur.left);

            // connect
            cur.left = null;
            if (!s.isEmpty()){
                cur.right = s.peek();
            }else {
                cur.right = null;
            }
        }
    }


    // 不太理解
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
