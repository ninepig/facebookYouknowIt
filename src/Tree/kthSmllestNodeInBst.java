package Tree;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/8.
 */
public class kthSmllestNodeInBst {
    private int smallest = Integer.MAX_VALUE;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        travel(root,k);
        return smallest;
    }

    private void travel(TreeNode root , int k) {
        if (root == null){
            return ;
        }
        travel(root.left , k);
        count++;
        if (count == k){
            smallest = root.val;
        }
        travel(root.right, k);
    }


    public int KthSmallestStack(TreeNode root , int k){
        if (root == null) return 0;
        TreeNode cur = root;
        int count = 0;
        int res = 0;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty()||cur!=null){
            while(cur != null){
                s.push(cur);
                cur =cur.left;
            }
            cur = s.pop();
            count++;
            if (count == k - 1){
                res = cur.val;
            }
            cur = cur.right;
            // 因为用了cur上面的那种形式，所以不用Push
        }
        return res;
    }
}