package Tree;

/**
 * Created by yangw on 2019/7/8.
 * 同balanceTree
 * 全局变量 + travesal
 * 只不过再travel的时候对值处理的方式不同
 */
public class binaryTreeMaxDepthSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));
        max = Math.max(max,left+right+root.val);

        return root.val + Math.max(left,right);
    }
}
