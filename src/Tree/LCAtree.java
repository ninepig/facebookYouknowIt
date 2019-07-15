package Tree;

import java.util.ArrayList;

/**
 * Created by yangw on 2019/7/8.
 */
public class LCAtree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if (root.val > p.val && root.val >q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }

    class TreeNodeS{
        int val;
        ArrayList<TreeNodeS> children;//多叉树
        public TreeNodeS(int val){
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    class ResultType {
        TreeNodeS node; //返回的节点
        int depth; //以该返回节点为根的树里最深的节点的深度depth

        public ResultType(TreeNodeS node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lowestCaOfBT(TreeNode root, TreeNode p , TreeNode q){
        if (root == null || p == null || q == null) return root;
        TreeNode left = lowestCaOfBT(root.left ,p , q);
        TreeNode right = lowestCaOfBT(root.right,p,q);
        if (left!=null && right!=null){
            return root;
        }
        if (left!=null){
            return left;
        }
        if (right!= null){
            return right;
        }
        return null;
    }

    public TreeNodeS LowestCaOfTree(TreeNodeS root){
        return dfs(root,0).node;
    }

    public ResultType dfs(TreeNodeS root, int depth) {
        if (root == null){
            return new ResultType(root, 0);
        }
        int maxDepth = 0;
        int count = 0;
        TreeNodeS maxDepthNode =null;
        for (TreeNodeS child : root.children){
            ResultType temp = dfs(child,depth);
            int tempDepth = temp.depth;
            if (tempDepth + 1 > maxDepth){
                maxDepth = tempDepth+1;
                maxDepthNode = temp.node;
                count = 1;
            }else if(tempDepth +1 == maxDepth){
                count++;
            }
        }
        if (count > 1){
            //如果超过1  就表示是当前节点
            return new ResultType(root,depth);
        }else {
            //如果不超过1 就用global的节点
            return new ResultType(maxDepthNode , maxDepth);
        }
    }
}
