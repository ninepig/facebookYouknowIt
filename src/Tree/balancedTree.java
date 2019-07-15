package Tree;

import java.util.Map;

/**
 * Created by yangw on 2019/7/8.
 * 这道题就是典型的 travlsal + 全局变量记录某个特定的情况
 * 变身为算树的深度，然后左右大小比较。
 */
public class balancedTree {
    boolean ifBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        helper(root);
        return ifBalanced;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1){
            ifBalanced = false;
        }
        return Math.max(left,right) + 1;
    }
}
