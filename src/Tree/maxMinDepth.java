package Tree;

import sun.reflect.generics.tree.Tree;

/**
 * Created by yangw on 2019/7/2.
 */
public class maxMinDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        // if(root.left == null) return maxDepth(root.right);
        // if(root.right == null) return maxDepth(root.left);
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public int minDepth(TreeNode root){
        if (root == null)return 0;
        if (root.right == null && root.left == null){
            return 1;
        }
        if (root.left == null){
            return minDepth(root.right)+1;
        }
        if (root.right == null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
