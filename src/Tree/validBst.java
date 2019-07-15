package Tree;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/8.
 */
public class validBst {
    TreeNode pre = null;
    public boolean validBst(TreeNode root){
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur != null){
            while (cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (pre != null && pre.val > cur.val){
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}
