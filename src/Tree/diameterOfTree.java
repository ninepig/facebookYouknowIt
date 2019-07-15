package Tree;

/**
 * Created by yangw on 2019/7/8.
 * 又是一个 travl + 全局变量
 */
public class diameterOfTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max,left+right);

        return Math.max(left,right)+1;
    }
}
